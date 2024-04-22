package com.example.vitality.entities;

import jakarta.persistence.*;
import jdk.jfr.Category;

@Entity
@Table(name="Product")
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct;
    @Column(name = "name",nullable = false,length = 30)
    private String name;
    @Column(name = "price",nullable = false)
    private int price;
    @Column(name = "stock",nullable = false)
    private int stock;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    public Product() {
    }

    public Product(int idProduct, String name, int price, int stock, Category category) {
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
