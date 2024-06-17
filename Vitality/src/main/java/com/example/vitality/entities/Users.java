package com.example.vitality.entities;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name="users")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30, unique = true)
    private String username;
    @Column(name = "email",nullable = false,length = 100)
    private String email;
    @Column(length = 200)
    private String password;

    private Boolean enabled;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Role> roles;

    @Column(name = "address",nullable = false,length = 100)

    private String address;
    @Column(name = "weight",nullable = false)
    private Float weight;
    @Column(name = "height",nullable = false)
    private int height;
    @Column(name = "subscription",nullable = false,length = 10)
    private boolean subscription;
    @Column(name = "healthProfessional",nullable = false,length = 10)
    private boolean healthProfessional;

    public Users() {
    }


    public Users(Long id, String username, String email, String password, String address, Float weight, int height, boolean subscription, boolean healthProfessional) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
        this.weight = weight;
        this.height = height;
        this.subscription = subscription;
        this.healthProfessional = healthProfessional;
    }

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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
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

    public boolean isSubscription() {
        return subscription;
    }

    public void setSubscription(boolean subscription) {
        this.subscription = subscription;
    }

    public boolean isHealthProfessional() {
        return healthProfessional;
    }

    public void setHealthProfessional(boolean healthProfessional) {
        this.healthProfessional = healthProfessional;
    }
}