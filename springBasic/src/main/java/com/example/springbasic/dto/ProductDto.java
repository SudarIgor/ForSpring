package com.example.springbasic.dto;

import com.example.springbasic.model.Product;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.io.Serializable;


public class ProductDto implements Serializable {

    private long id;

    @NotEmpty(message = "Товар должен иметь название")
    @Length (min = 3, max = 255, message = "Название товара должно состоять от 3 до 255 символов")
    private String title;

    @NotNull(message = "Товар должен иметь цену")
    @DecimalMin(value = "0.01", message = "Цена должна быть более 0")
    private double price;

    @NotEmpty
    @Length(min = 3, max = 20, message = "Название категории должно быть от 3 до 20 символов")
    private String category;

    public ProductDto() {
    }

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.category = product.getCategory().getTitle();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }
}
