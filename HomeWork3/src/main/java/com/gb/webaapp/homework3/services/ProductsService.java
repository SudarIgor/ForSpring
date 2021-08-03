package com.gb.webaapp.homework3.services;


import com.gb.webaapp.homework3.model.Product;
import com.gb.webaapp.homework3.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    private ProductsRepository productsRepository;

    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Product> findAll() {
        return productsRepository.findAll();
    }

    public Product findById(Long id) {
        return productsRepository.findById(id);
    }

    public void save(Product product) {
        productsRepository.save(product);
    }
}
