package com.example.vitality.dtos;

public class UserDTO {

    private Long id;
    private String username;
    private String email;
    private String password;

    private Boolean enabled;
    private String address;
    private Float weight;
    private int height;
    private boolean subscription;
    private boolean healthProfessional;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
