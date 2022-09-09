package com.example.springbasic.DTO;

import com.example.springbasic.model.Category;

import java.io.Serializable;

public class CategoryDto implements Serializable {
    private final Long id;
    private final String title;

    public CategoryDto(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public CategoryDto (Category category){
        this.id = category.getId();
        this.title = category.getTitle();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "title = " + title + ")";
    }
}
