package com.gd.sudar.homework7_sprdata.dtos;

import com.gd.sudar.homework7_sprdata.model.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String title;
    private double price;


    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();

    }
}
