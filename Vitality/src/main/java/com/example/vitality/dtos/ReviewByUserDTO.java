package com.example.vitality.dtos;

public class ReviewByUserDTO {

    private String nameUser;
    private int quantityReview;

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public int getQuantityReview() {
        return quantityReview;
    }

    public void setQuantityReview(int quantityReview) {
        this.quantityReview = quantityReview;
    }
}
