package com.gb.sudar.homework6.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String name;

    @Column(name = "price")
    private double price;

    @ManyToMany
    @JoinTable(
            name = "orders",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id")
    )
    private List<Client> clients;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product: " + ", name='" + name  + ", price=" + price;
    }
}
