package com.example.vitality.dtos;

//DIEGO
public class RecommendationByUserDTO {
    private String nameUser;
    private int quantityRecommendation;


    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public int getQuantityRecommendation() {
        return quantityRecommendation;
    }

    public void setQuantityRecommendation(int quantityRecommendation) {
        this.quantityRecommendation = quantityRecommendation;
    }
}
