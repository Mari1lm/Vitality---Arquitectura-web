package com.example.vitality.dtos;

//DIEGO
public class RecommendationByUserDTO {
    private int idUser;
    private String username;
    private int quantityRecommendation;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

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
