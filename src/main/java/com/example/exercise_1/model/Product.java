package com.example.exercise_1.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String name;
    private String description;
    private double price;
    private  String manufacture;

    public Product(Long id, String name, String description, double price, String manufacture) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.manufacture = manufacture;
    }

    public Product(String name, String description, double price, String manufacture) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.manufacture = manufacture;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }
}
