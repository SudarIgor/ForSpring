package com.example.springbasic.DTO;

import java.io.Serializable;

public class CategoryDto implements Serializable {
    private final Long id;
    private final String title;

    public CategoryDto(Long id, String title) {
        this.id = id;
        this.title = title;
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
