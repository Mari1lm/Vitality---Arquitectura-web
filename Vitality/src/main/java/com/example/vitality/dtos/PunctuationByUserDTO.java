package com.example.vitality.dtos;

public class PunctuationByUserDTO {

    private String nameUser;

    private int sumPunctuations;

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public int getSumPunctuations() {
        return sumPunctuations;
    }

    public void setSumPunctuations(int sumPunctuations) {
        this.sumPunctuations = sumPunctuations;
    }
}
