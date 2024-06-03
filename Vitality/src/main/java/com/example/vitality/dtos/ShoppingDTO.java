package com.example.vitality.dtos;

import com.example.vitality.entities.Product;
import com.example.vitality.entities.Users;

public class ShoppingDTO {
    private int numOrderShopping;
    private int dateShopping;
    private int totalShopping;
    private Users user;
    private Product product;

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

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
