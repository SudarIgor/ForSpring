package com.example.springbasic.dto;

import com.example.springbasic.model.Cart;
import com.example.springbasic.model.CartItm;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class CartDto {
    private List<CartItmDto> productsDto;

    public CartDto(Cart cart) {
        this.productsDto = cart.getProducts().stream()
                .map(CartItmDto::new)
                .collect(Collectors.toList());
    }

    public List<CartItmDto> getProductsDto() {
        return productsDto;
    }

    public void setProductsDto(List<CartItmDto> productsDto) {
        this.productsDto = productsDto;
    }
}
