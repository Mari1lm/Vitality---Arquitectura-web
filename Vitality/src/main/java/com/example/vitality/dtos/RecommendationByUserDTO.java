package com.example.vitality.dtos;

//DIEGO
public class RecommendationByUserDTO {
    private String username;

    private int quantityRecommendation;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getQuantityRecommendation() {
        return quantityRecommendation;
    }

    public void setQuantityRecommendation(int quantityRecommendation) {
        this.quantityRecommendation = quantityRecommendation;
    }
}
