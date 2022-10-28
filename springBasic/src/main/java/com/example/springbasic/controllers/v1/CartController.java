package com.example.springbasic.controllers.v1;

import com.example.springbasic.dto.CartDto;
import com.example.springbasic.dto.ProductDto;
import com.example.springbasic.model.Cart;
import com.example.springbasic.services.CartService;
import com.example.springbasic.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/cart")
public class CartController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @Autowired
    private Cart cart;


    @PostMapping("")
    public CartDto  save(@RequestBody  ProductDto productDto){

        cartService.addProduct(productService.findById(productDto.getId()).get());

        return new CartDto(cart);
    }

    @GetMapping("")
    public CartDto show(){
        return new CartDto(cart);
    }

    @DeleteMapping
    public CartDto delete (){
        return new CartDto(cart);
    }


}
