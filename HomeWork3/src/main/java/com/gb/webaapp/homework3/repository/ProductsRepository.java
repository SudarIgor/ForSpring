package com.gb.webaapp.homework3.repository;

import com.gb.webaapp.homework3.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductsRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        this.products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Bread", 47),
                new Product(2L, "Butter", 290),
                new Product(3L, "Cheese", 300),
                new Product(4L, "Milk", 60),
                new Product(5L, "Sausage", 480),
                new Product(6L, "Salad", 90),
                new Product(7L, "Cupcake", 35),
                new Product(8L, "Loaf", 55)
        ));
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }

    public Product findById(Long id) {
        return products.stream().filter(s -> s.getId().equals(id)).findFirst().get();
    }

    public void save(Product product) {
        products.add(product);
    }
}
