package com.example.vitality.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Shopping")
public class Shopping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numOrderShopping;
    @Column(name = "dateShopping",nullable = false)
    private int dateShopping;
    @Column(name = "totalShopping",nullable = false)
    private int totalShopping;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    @ManyToOne
    @JoinColumn(name = "productoId")
    private Product product;

    public Shopping() {

    }

    public Shopping(int numOrderShopping, int dateShopping, int totalShopping, User user, Product product) {
        this.numOrderShopping = numOrderShopping;
        this.dateShopping = dateShopping;
        this.totalShopping = totalShopping;
        this.user = user;
        this.product = product;
    }

    public int getNumOrderShopping() {
        return numOrderShopping;
    }

    public void setNumOrderShopping(int numOrderShopping) {
        this.numOrderShopping = numOrderShopping;
    }

    public int getDateShopping() {
        return dateShopping;
    }

    public void setDateShopping(int dateShopping) {
        this.dateShopping = dateShopping;
    }

    public int getTotalShopping() {
        return totalShopping;
    }

    public void setTotalShopping(int totalShopping) {
        this.totalShopping = totalShopping;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
