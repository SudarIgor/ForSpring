package com.example.springbasic.services;

import com.example.springbasic.model.Product;
import com.example.springbasic.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productDAO) {
        this.productRepository = productDAO;
    }

    public Optional<Product> findById (long id){
        return productRepository.findById(id);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public void save (Product product){
        productRepository.save(product);
    }

    public void updatePrice(long id, double prise) {
        productRepository.changePriceBy(id, prise);
    }

    public void update(Product product) {
        productRepository.save(product);
    }

    public void deleteById(long id) {
        productRepository.deleteById(id);
    }

    public List<Product> findByPriceGreaterThanEqual(Double min) {
        return productRepository.findByPriceGreaterThanEqual(min);
    }

    public void changePriceBy(long id, Double ch) {
        productRepository.changePriceBy(id, ch);
    }
}
