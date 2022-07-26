package com.example.springbasic.repositories;

import com.example.springbasic.model.Product;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List <Product> productList;
    private long count;


    @PostConstruct
    public void init() {
        this.productList = new ArrayList<>(Arrays.asList(
                new Product(1L, "Bread", 47),
                new Product(2L, "Butter", 290),
                new Product(3L, "Cheese", 300),
                new Product(4L, "Milk", 60),
                new Product(5L, "Sausage", 480),
                new Product(6L, "Salad", 90),
                new Product(7L, "Cupcake", 35),
                new Product(8L, "Loaf", 55)

        ));
        count =productList.size();
    }

    public Product findeById(long id){
        return productList.stream().filter(e -> e.getId() == id).findFirst().get();
    }

    public List<Product> findeAll(){
        return Collections.unmodifiableList(productList);
    }

    public void save(Product product){
        product.setId(count+1);
        productList.add(product);
    }

}
