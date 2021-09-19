package com.gd.sudar.homework7_sprdata.controllers;


import com.gd.sudar.homework7_sprdata.dtos.ProductDto;
import com.gd.sudar.homework7_sprdata.model.Product;
import com.gd.sudar.homework7_sprdata.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;


    @GetMapping("/products")
    public List<ProductDto> findAll(){
        List<Product> products = new ArrayList<>(productService.findAll());
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product p: products) {
            productDtos.add(new ProductDto(p));
        }
        return productDtos;
    }

    @GetMapping("/products/{id}")
    public ProductDto findById(@PathVariable Long id){
        return new ProductDto( productService.findById(id).get());
    }

    @GetMapping("/products/delete/{id}")
    public List<ProductDto> deleteById(@PathVariable Long id){
        productService.deleteById(id);
        return findAll();
    }

    @GetMapping("/products/filter")
    public List<ProductDto> findByBetweenPrice(
            @RequestParam (name = "min_price", required = false) Double min_price,
            @RequestParam (name = "max_price", required = false) Double max_price) {
        List<Product> products= null;
        List<ProductDto> productDtos = null;

        if ( (max_price!=null) && (min_price!=null) ){
            products = new ArrayList<>(productService.findByBetweenPcrie(min_price, max_price));
            productDtos = new ArrayList<>();
            for (Product p : products) {
                productDtos.add(new ProductDto(p));
            }
            return productDtos;
        }
        if ( (max_price==null) && (min_price==null) ){
            products = new ArrayList<>(productService.findAll());
            productDtos = new ArrayList<>();
            for (Product p: products) {
                productDtos.add(new ProductDto(p));
            }
            return productDtos;
        }

        if ( (min_price==null) && (max_price!=null) ) {
            products = new ArrayList<>(productService.findByMaxPrice(max_price));
            productDtos = new ArrayList<>();
            for (Product p: products) {
                productDtos.add(new ProductDto(p));
            }
            return productDtos;
        }

        if ( (min_price!=null) && (max_price==null) ) {
            products = new ArrayList<>(productService.findByMinPrice(min_price));
            productDtos = new ArrayList<>();
            for (Product p: products) {
                productDtos.add(new ProductDto(p));
            }
         return productDtos;
        }

    return null;
    }

    @PostMapping("/products")
    public ProductDto save(@RequestBody ProductDto productDto) {
        Product product = new Product();
        product.setPrice(productDto.getPrice());
        product.setTitle(productDto.getTitle());
        productService.save(product);
        return new ProductDto(product);
    }


}
