package com.gd.sudar.homework7_sprdata.services;


import com.gd.sudar.homework7_sprdata.model.Product;
import com.gd.sudar.homework7_sprdata.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public Optional<Product> findById (Long id){
        return productRepository.findById(id);
    }

    public  void save(Product product) {
        productRepository.save(product);
    }

    public void deleteById(long id){
        productRepository.deleteById(id);
    }
}
