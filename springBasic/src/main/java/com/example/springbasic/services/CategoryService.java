package com.example.springbasic.services;

import com.example.springbasic.model.Category;
import com.example.springbasic.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Optional<Category> findByTitle(String title){
        return categoryRepository.findByTitle(title);
    }


}
