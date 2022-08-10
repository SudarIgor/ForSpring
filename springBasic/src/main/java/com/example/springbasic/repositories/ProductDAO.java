package com.example.springbasic.repositories;

import com.example.springbasic.model.Product;
import com.example.springbasic.model.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ProductDAO {
    private Factory factory;

    @Autowired
    public ProductDAO(Factory factory) {
        this.factory = factory;
    }

    public Product findeById(long id){
        Session session = factory.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.getTransaction().commit();
        return product;
    }

    public List<Product> findeAll(){
        Session session = factory.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Product> products = session.createQuery("SELECT p FROM Product p ORDER BY p.id", Product.class).getResultList();

        session.getTransaction().commit();
        return products;
    }

    public void save(Product product){
        Session session = factory.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();

    }

    public void updatePrice(long id, double cost) {
        Session session = factory.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        double newCost = product.getPrice() + cost;
        product.setPrice(newCost);
        session.getTransaction().commit();
    }

    public void update(Product product) {
        long id = product.getId();
        Session session = factory.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Product chProduct = session.get(Product.class, id);
        chProduct.setTitle(product.getTitle());
        chProduct.setPrice(product.getPrice());
        session.getTransaction().commit();
    }

    public void delete(long id){
        Session session = factory.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery("DELETE from products WHERE id = " + id).executeUpdate();
        session.getTransaction().commit();
    }

    public List<User> showUsers(long id){
        Session session = factory.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<User> users = session.get(Product.class, id).getUsers();
        System.out.println(users);
        session.close();
        return users;
    }
}
