package com.example.springbasic.controllers.v1;


import com.example.springbasic.dto.CategoryDto;
import com.example.springbasic.exceptions.ResourceNotFoundException;
import com.example.springbasic.model.Category;
import com.example.springbasic.services.CategoryService;
import com.example.springbasic.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/v1/categories")
public class CategoryController {
    private ProductService productService;
    private CategoryService categoryService;

    @Autowired
    public CategoryController(ProductService productServis, CategoryService categoryRepository) {
        this.productService = productServis;
        this.categoryService = categoryRepository;
    }

    @GetMapping("")
    public List<CategoryDto>  categoryAll(){

        return categoryService.findAll().stream().map(CategoryDto:: new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CategoryDto categoryById(@PathVariable long id){

        return new CategoryDto(categoryService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category id = " + id + " not found")));
    }

    @PostMapping("")
        public CategoryDto save(@RequestBody CategoryDto categoryDto){
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setTitle(categoryDto.getTitle());
        categoryService.save(category);
        return new CategoryDto(category);
    }

    @PutMapping("/{id}/update")
    public CategoryDto update(@PathVariable long id, @RequestBody CategoryDto categoryDto){
        Category category = categoryService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category id = " + id + " not found"));
         category.setId(categoryDto.getId());
        category.setTitle(categoryDto.getTitle());
        categoryService.save(category);
        return new CategoryDto(category);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        productService.deleteById(id);
        categoryAll();
    }

}
