package com.example.springbasic.controllers.v1;


import com.example.springbasic.exceptions.DataValidationException;
import com.example.springbasic.exceptions.ResourceNotFoundException;
import com.example.springbasic.model.Category;
import com.example.springbasic.model.Product;
import com.example.springbasic.dto.ProductDto;
import com.example.springbasic.services.CategoryService;
import com.example.springbasic.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;


@RestController
@RequestMapping("/v1/products")
public class ProductController {
    private ProductService productService;
    private CategoryService categoryService;

    @Autowired
    public ProductController(ProductService productServis, CategoryService categoryRepository) {
        this.productService = productServis;
        this.categoryService = categoryRepository;
    }

    @GetMapping("")
    public Page<ProductDto> productAll(@RequestParam (required = false, defaultValue = "0") int pageIndex,
                                       @RequestParam (defaultValue = "10") int pageSize ){
        if (pageIndex <1) pageIndex = 1;
        if (pageSize < 1) pageSize = 10;
        return productService.findAll(pageIndex - 1, pageSize).map(ProductDto:: new);
    }

    @GetMapping("/{id}")
    public ProductDto productById(@PathVariable long id){

        return new ProductDto(productService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product id = " + id + " not found")));
    }

    @PostMapping("")
    public ProductDto save(@RequestBody @Validated ProductDto productDTO, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            throw new DataValidationException(bindingResult.getAllErrors()
                    .stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList()));
        }

        Category category = categoryService.findByTitle(productDTO.getCategory())
                .orElseThrow(() -> new ResourceNotFoundException("Category = " + productDTO.getCategory() + " not found"));

        Product product = new Product();

        product.setTitle(productDTO.getTitle());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);

        productService.save(product);
        return new ProductDto(product);
    }

    @PutMapping("")
    public ProductDto update(@RequestBody @Validated ProductDto productDTO, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
           throw new DataValidationException(bindingResult.getAllErrors()
                   .stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList()));
        }

        Product product = productService.findById(productDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Product id = " + productDTO.getId() + " not found"));

        Category category = categoryService.findByTitle(productDTO.getCategory())
                .orElseThrow(() -> new ResourceNotFoundException("Category = " + productDTO.getCategory() + " not found"));

        product.setTitle(productDTO.getTitle());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);

        productService.save(product);
        return new ProductDto(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        productService.deleteById(id);
        productAll(1, 10);

    }

}
