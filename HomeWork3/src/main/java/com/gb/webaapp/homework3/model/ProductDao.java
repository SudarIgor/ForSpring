package com.gb.webaapp.homework3.model;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDao {
    Factory factory;
    Session session;

    public ProductDao() {
        session = null;
    }

    @Autowired
    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    public List<Product> findAll() {
        session = factory.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Product> products = session.createQuery("SELECT p FROM Product p", Product.class).getResultList();
        System.out.println(products);
        session.getTransaction().commit();
        return products;
    }

    public Product findById(Long id) {
        session = factory.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Product productFromDb = session.createQuery("SELECT p FROM Product p WHERE p.id = :id", Product.class)
                .setParameter("id", id)
                .getSingleResult();
        return productFromDb;
    }

    public void save(Product product) {
        session = factory.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
    }

    public Product changeCostFor1(Long id, int a){
//TODO
        return findById(id);
    }



}
