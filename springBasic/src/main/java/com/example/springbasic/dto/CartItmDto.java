package com.example.springbasic.dto;

import com.example.springbasic.model.CartItm;
import org.springframework.stereotype.Component;

@Component
public class CartItmDto {
    private ProductDto productDto;
    private int count;

    public CartItmDto(CartItm cartItm) {
        this.productDto = new ProductDto(cartItm.getProduct());
        this.count = cartItm.getCount();
    }


    public CartItmDto() {

    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void changeCount (int a){
        count= count + a;
    }



}
