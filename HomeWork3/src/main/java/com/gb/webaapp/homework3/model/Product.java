package com.gb.webaapp.homework3.model;


import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "cost")
    private double cost;

    public Product() {
    }

    public Product(long id, String title, double cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public Product(Long id, String title, double cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public Product(String title, double cost) {
        this.title = title;
        this.cost = cost;
    }

    public Long getId() {
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString(){
        return String.format("Product [id = %d, title = '%s', cost = %.2f]", id, title, cost);
    }

}
