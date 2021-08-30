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
public class ClientDao {




    Factory factory;

    @Autowired
    public ClientDao(Factory factory) {
        this.factory = factory;
    }

    public List<Client> findAll() {
        Session session = factory.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Client> clients = session.createQuery("SELECT c FROM Client c", Client.class).getResultList();
        session.beginTransaction().commit();
        return clients;
    }

    public Client findById(Long id) {
        Session session = factory.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Client clientFromDb = session.createQuery("SELECT c FROM Client c WHERE c.id = :id", Client.class)
                .setParameter("id", id)
                .getSingleResult();
        session.getTransaction().commit();
        return clientFromDb;

    }

    public void save(Client client) {
        Session session = factory.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(client);
        session.getTransaction().commit();
    }

    public List<Product> findByIdProducts(Long id) {
        Session session = factory.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Client clientFromDb = session.createQuery("SELECT c FROM Client c WHERE c.id = :id", Client.class)
                .setParameter("id", id)
                .getSingleResult();
        List<Product> products = clientFromDb.getProducts();
        List<Product> newList = new ArrayList<>(List.copyOf(products));
        newList.clear();
        session.getTransaction().commit();

        return products;
    }
}
