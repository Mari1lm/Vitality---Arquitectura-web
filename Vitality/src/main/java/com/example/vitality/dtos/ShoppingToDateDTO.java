package com.example.vitality.dtos;

import java.time.LocalDate;

public class ShoppingToDateDTO {
    private LocalDate dateShopping;
    private int count;

    public LocalDate getDateShopping() {
        return dateShopping;
    }

    public void setDateShopping(LocalDate dateShopping) {
        this.dateShopping = dateShopping;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}


