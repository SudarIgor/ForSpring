package com.example.springbasic.Services;

import com.example.springbasic.model.Product;
import com.example.springbasic.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findById (long id){
        return productRepository.findeById(id);
    }

    public List<Product> findAll(){
        return productRepository.findeAll();
    }

    public void save (Product product){
        productRepository.save(product);
    }

}
