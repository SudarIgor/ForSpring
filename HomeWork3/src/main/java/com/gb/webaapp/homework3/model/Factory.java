package com.gb.webaapp.homework3.model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Factory {
    private  SessionFactory sessionFactory;
    public Factory() {
    }
    @PostConstruct
    public void init() {
         sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @PreDestroy
    public void close(){
        sessionFactory.close();
    }
}
