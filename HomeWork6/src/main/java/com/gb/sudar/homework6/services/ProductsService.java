package com.gb.sudar.homework6.services;

import com.gb.sudar.homework6.model.Client;
import com.gb.sudar.homework6.model.Product;
import com.gb.sudar.homework6.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductsService {
    private ProductDao productDao;

    @Autowired
    public ProductsService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> findAll() {
        return productDao.findAll();
    }

    public Product findById(Long id) {
        return productDao.findById(id);
    }

    public void save(Product product) {
        productDao.save(product);
    }

    public List<String> findByIdClients(Long id){ return productDao.findByIdClients(id);}


}
