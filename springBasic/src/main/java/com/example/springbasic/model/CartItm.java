package com.example.springbasic.model;


import java.util.Objects;

public class CartItm {
    private Product product;
    private int count;

    public CartItm() {
    }

    public CartItm(Product product, int count) {
        this.product = product;
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void changeCount (int a){
        count= count + a;
        System.out.println(count);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItm cartItm = (CartItm) o;
        return count == cartItm.count && Objects.equals(product, cartItm.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, count);
    }
}
