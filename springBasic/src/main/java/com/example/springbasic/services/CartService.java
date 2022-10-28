package com.example.springbasic.services;

import com.example.springbasic.dto.ProductDto;
import com.example.springbasic.model.Cart;
import com.example.springbasic.model.CartItm;
import com.example.springbasic.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService
{
    private Cart cart;

    @Autowired
    public CartService(Cart cart) {
        this.cart = cart;
    }

    public void addProduct(Product product){
        boolean found = false;

        if(cart.getProducts().isEmpty()) {
            cart.getProducts().add(new CartItm(product, 1));
            return;
        }

        for (CartItm c: cart.getProducts()) {
            System.out.println(new ProductDto(c.getProduct()));
            if(c.getProduct().equals(product)) {
                c.changeCount(1);
                found = true;
            }
        }
        if (!found) {
            cart.getProducts().add(new CartItm(product, 1));
        }
    }

    public void deleteProduct(Product product) {

        if (!cart.getProducts().isEmpty()) {
            for (CartItm c : cart.getProducts()) {
                if (c.getProduct().equals(product)){
                    if (c.getCount() == 1) {
                        cart.getProducts().remove(c);
                        break;
                    }
                    c.setCount(-1);
                    break;
                }
            }
        }
    }

}
