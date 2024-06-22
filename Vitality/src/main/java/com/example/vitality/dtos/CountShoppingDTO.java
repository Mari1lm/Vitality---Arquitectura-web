package com.example.vitality.dtos;

import java.time.LocalDate;

public class CountShoppingDTO {
    private String username;
    private int count;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}