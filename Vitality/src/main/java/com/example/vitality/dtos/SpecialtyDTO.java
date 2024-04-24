package com.example.vitality.dtos;


import com.example.vitality.entities.User;

public class SpecialtyDTO {
    private int idspecialty;
    private String specialization;
    private String profileDescription;

    public int getIdspecialty() {
        return idspecialty;
    }

    public void setIdspecialty(int idspecialty) {
        this.idspecialty = idspecialty;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

}

