package com.example.vitality.dtos;

import java.time.LocalDate;

public class ShoppingToDateDTO {
    private String dateShopping;
    private int count;

    public String getDateShopping() {
        return dateShopping;
    }

    public void setDateShopping(String dateShopping) {
        this.dateShopping = dateShopping;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}


