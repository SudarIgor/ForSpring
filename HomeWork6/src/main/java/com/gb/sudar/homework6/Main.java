package com.gb.sudar.homework6;


import com.gb.sudar.homework6.repository.ClientDao;
import com.gb.sudar.homework6.repository.ProductDao;
import com.gb.sudar.homework6.services.ClientsService;
import com.gb.sudar.homework6.services.ProductsService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);

        ClientsService  clientsService = context.getBean("clientsService", ClientsService.class);
        ProductsService  productsService = context.getBean("productsService", ProductsService.class);
        System.out.println(clientsService.findByIdProducts(1l));
        System.out.println(productsService.findByIdClients(1l));


    }

}
