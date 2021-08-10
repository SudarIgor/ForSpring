package com.gb.webaapp.homework3.services;


import com.gb.webaapp.homework3.model.Product;
import com.gb.webaapp.homework3.model.ProductDao;
import com.gb.webaapp.homework3.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
//    private ProductsRepository productsRepository;
    private ProductDao productDao;

    @Autowired
    public ProductsService(ProductDao productDao) {
        this.productDao = productDao;
    }

    //    @Autowired
//    public ProductsService(ProductsRepository productsRepository) {
//        this.productsRepository = productsRepository;
//    }

//    public List<Product> findAll() {
//        return productsRepository.findAll();
//    }
//
//    public Product findById(Long id) {
//        return productsRepository.findById(id);
//    }
//
//    public void save(Product product) {
//        productsRepository.save(product);
//    }
//
//    public void changeCost(Long id, int a){
//       findById(id).setCost(findById(id).getCost() + a);
//    }

    public List<Product> findAll() {
        return productDao.findAll();
    }

    public Product findById(Long id) {
        return productDao.findById(id);
    }

    public void save(Product product) {
        productDao.save(product);
    }

    public void changeCost(Long id, int a){
        productDao.changeCostFor1(id,a);
    }
}
