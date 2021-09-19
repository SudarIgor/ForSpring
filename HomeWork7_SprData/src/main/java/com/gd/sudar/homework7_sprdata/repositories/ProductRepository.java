package com.gd.sudar.homework7_sprdata.repositories;

import com.gd.sudar.homework7_sprdata.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
