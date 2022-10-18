package com.example.springbasic.repositories;

import com.example.springbasic.model.Product;
import com.example.springbasic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository  extends JpaRepository<Product,Long> {

    @Transactional
    @Modifying
    @Query ("update Product p set p.price = p.price + :ch where p.id = :id")
    void changePriceBy(@Param("id") long id, @Param("ch") double ch);

    List<Product> findByPriceGreaterThanEqual(Double min);
}
