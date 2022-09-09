package com.example.springbasic.controllers;


import com.example.springbasic.model.Category;
import com.example.springbasic.model.Product;
import com.example.springbasic.DTO.ProductDto;
import com.example.springbasic.repositories.CategoryRepository;
import com.example.springbasic.repositories.ProductRepository;
import com.example.springbasic.services.CategoryService;
import com.example.springbasic.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products/rest")
public class ProductRestController {
    private ProductService productService;
    private CategoryService categoryService;

    @Autowired
    public ProductRestController(ProductService productServis, CategoryService categoryRepository) {
        this.productService = productServis;
        this.categoryService = categoryRepository;
    }

    @GetMapping("")
    public List<ProductDto> productAll(@RequestParam (required = false, defaultValue = "0") int pageIndex,
                                       @RequestParam (defaultValue = "10") int pageSize ){

        return productService.findAll(pageIndex, pageSize).stream().map(ProductDto:: new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional <ProductDto> productById(@PathVariable long id){
        return Optional.of(new ProductDto(productService.findById(id).get()));
    }

    @GetMapping("/filter")
    public List<ProductDto> productByFilter(@RequestParam (required = false) Double min, @RequestParam (required = false) Double max ) {

        return productService.findByPriceGreaterThanEqual( min)
                .stream().map(ProductDto::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}/ch_pr")
    public ProductDto changePrice(@PathVariable long id, @RequestParam (name = "ch", required = false) Double ch){
        if (ch != null) productService.changePriceBy(id, ch);
        return new ProductDto(productService.findById(id).get());
    }

    @PostMapping("/new")
    //    @RequestBody Product product - означает, что прилетевший в теле запроса json необходимо преобразовать к Product
    public ProductDto save(@RequestBody ProductDto productDTO){
        Product product = new Product();
        product.setTitle(productDTO.getTitle());
        product.setPrice(productDTO.getPrice());
        Category category = categoryService.findByTitle(productDTO.getCategory()).get();
        product.setCategory(category);
        productService.save(product);
        return new ProductDto(product);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        productService.deleteById(id);
        productAll(1, 10);

    }

}
