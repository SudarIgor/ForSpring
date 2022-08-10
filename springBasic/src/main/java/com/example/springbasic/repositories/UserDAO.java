package com.example.springbasic.repositories;

import com.example.springbasic.model.Product;
import com.example.springbasic.model.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO {
    private Factory factory;
    
    @Autowired
    public UserDAO(Factory factory) {
        this.factory = factory;
    }

    public List<User> findAll() {
        Session session = factory.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<User> users = session.createQuery("SELECT u FROM User u", User.class).getResultList();

        session.getTransaction().commit();
        return users;
    }

    public User findById(long id) {
        Session session = factory.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        User user = session.get(User.class, id);

        session.getTransaction().commit();
        return user;

    }

    public List<Product> showProducts(long id){
        Session session = factory.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Product> products = session.get(User.class, id).getProducts();
        System.out.println(products);
        session.close();
        return products;
    }
}
