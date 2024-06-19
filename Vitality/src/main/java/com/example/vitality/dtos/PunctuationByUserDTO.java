package com.example.vitality.dtos;

public class PunctuationByUserDTO {

    private String username;

    private int sumPunctuations;
    private double averageReview;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSumPunctuations() {
        return sumPunctuations;
    }

    public void setSumPunctuations(int sumPunctuations) {
        this.sumPunctuations = sumPunctuations;
    }

    public double getAverageReview() {
        return averageReview;
    }

    public void setAverageReview(double averageReview) {
        this.averageReview = averageReview;
    }
}