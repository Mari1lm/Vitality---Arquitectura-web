package com.example.vitality.dtos;

public class RecommendationByUserDTO {
    private int idUser;
    private String nameUser;
    private int quantityRecommendation;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

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
