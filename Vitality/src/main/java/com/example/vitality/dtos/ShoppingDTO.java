package com.example.vitality.dtos;

import com.example.vitality.entities.Product;
import com.example.vitality.entities.Users;

import java.time.LocalDate;

public class ShoppingDTO {
    private int idShopping;
    private LocalDate dateShopping;
    private int totalShopping;
    private Users user;

    public int getIdShopping() {
        return idShopping;
    }

    public void setIdShopping(int idShopping) {
        this.idShopping = idShopping;
    }

    public LocalDate getDateShopping() {
        return dateShopping;
    }

    public void setDateShopping(LocalDate dateShopping) {
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

}
