package com.example.vitality.dtos;

public class ReviewByUserDTO {

    private String username;
    private int quantityReview;

    public String getUsername() {
        return username;
    }


    public int getQuantityReview() {
        return quantityReview;
    }

    public void setQuantityReview(int quantityReview) {
        this.quantityReview = quantityReview;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
