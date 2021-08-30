package com.gb.sudar.homework6;


import com.gb.sudar.homework6.repository.ClientDao;
import com.gb.sudar.homework6.repository.ProductDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        ProductDao productDao = context.getBean("productDao", ProductDao.class);
        ClientDao clientDao = context.getBean("clientDao", ClientDao.class);
        System.out.println(productDao.findById(1l));
        System.out.println(productDao.findByIdClients(4l));
        System.out.println(productDao.findByIdClients(8l));
        System.out.println(clientDao.findByIdProducts(1l));


    }

}
