package com.example.springbasic.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class Cart {
    private List<CartItm> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public List<CartItm> getProducts() {
        return products;
    }


    @Override
    public String toString() {
        return "Cart{" +
                "products=" + products +
                '}';
    }
}
