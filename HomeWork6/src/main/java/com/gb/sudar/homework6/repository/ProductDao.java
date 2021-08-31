package com.gb.sudar.homework6.repository;

import com.gb.sudar.homework6.model.Client;
import com.gb.sudar.homework6.model.Factory;
import com.gb.sudar.homework6.model.Product;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDao {
    Factory factory;

    @Autowired
    public ProductDao(Factory factory) {
        this.factory = factory;
    }

    public List<Product> findAll() {
        Session session = factory.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Product> products = session.createQuery("SELECT p FROM Product p", Product.class).getResultList();
        session.beginTransaction().commit();
        return products;
    }

    public Product findById(Long id) {
        Session session = factory.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Product productFromDb = session.createQuery("SELECT p FROM Product p WHERE p.id = :id", Product.class)
                .setParameter("id", id)
                .getSingleResult();
        session.getTransaction().commit();
        return productFromDb;

    }

    public void save(Product product) {
        Session session = factory.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
    }

    public List<String> findByIdClients(Long id) {
        Session session = factory.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Product productFromDb = session.createQuery("SELECT p FROM Product p WHERE p.id = :id", Product.class)
                .setParameter("id", id)
                .getSingleResult();
        List<Client> clients = productFromDb.getClients();
        List<String> clientsList = new ArrayList<>();
        for (Client client : clients) {
            clientsList.add(client.getName());
        }
        session.getTransaction().commit();


        return clientsList;
    }
}
