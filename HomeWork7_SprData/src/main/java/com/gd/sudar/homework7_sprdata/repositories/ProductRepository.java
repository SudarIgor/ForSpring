package com.gd.sudar.homework7_sprdata.repositories;

import com.gd.sudar.homework7_sprdata.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByPriceLessThanEqual(Double price);
    List<Product> findAllByPriceGreaterThanEqual(Double price);
    List<Product> findAllByPriceBetween(Double min_price,Double max_price);

}
