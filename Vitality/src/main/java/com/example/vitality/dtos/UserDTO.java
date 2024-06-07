package com.example.vitality.dtos;

import com.example.vitality.entities.Role;
import com.example.vitality.entities.Specialty;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class UserDTO {

    private int idUser;
    private String username;
    private String email;
    private String password;
    private String address;
    private Float weight;
    private int height;
    private boolean subscription;
    private boolean healthProfessional;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean getSubscription() {
        return subscription;
    }

    public void setSubscription(boolean subscription) {
        this.subscription = subscription;
    }

    public boolean getHealthProfessional() {
        return healthProfessional;
    }

    public void setHealthProfessional(boolean healthProfessional) {
        this.healthProfessional = healthProfessional;
    }
}
