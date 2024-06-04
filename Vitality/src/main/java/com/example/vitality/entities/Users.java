package com.example.vitality.entities;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
    @Table(name="Users")
    public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    @Column(length = 30)
    private String username;
    @Column(name = "email",nullable = false,length = 100)
    private String email;
    @Column(length = 200)
    private String password;

    //ROLES BORRADO
    private Boolean enabled;

    @Column(name = "address",nullable = false,length = 100)

    private String address;
    @Column(name = "weight",nullable = false)
    private Float weight;
    @Column(name = "height",nullable = false)
    private int height;
    @Column(name = "subscription",nullable = false,length = 10)
    private Boolean subscription;
    @Column(name = "healthProfessional",nullable = false,length = 10)
    private Boolean healthProfessional;

    public Users() {
    }

    public Users(int idUser, String username, String email, String password, Boolean enabled, String address, Float weight, int height, Boolean subscription, Boolean healthProfessional) {
        this.idUser = idUser;
        this.username = username;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.address = address;
        this.weight = weight;
        this.height = height;
        this.subscription = subscription;
        this.healthProfessional = healthProfessional;
    }

    public int getIdUsers() {
        return idUser;
    }

    public void setIdUsers(int idUsers) {
        this.idUser = idUsers;
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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

    public Boolean isSubscription() {
        return subscription;
    }

    public void setSubscription(Boolean subscription) {
        this.subscription = subscription;
    }

    public Boolean isHealthProfessional() {
        return healthProfessional;
    }

    public void setHealthProfessional(Boolean healthProfessional) {
        this.healthProfessional = healthProfessional;
    }
}