package com.example.vitality.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Recommendation")
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecommendation;

    @Column(name = "descriptionRecommendation",nullable = false,length = 200)
    private String descriptionRecommendation;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Users user;

    public Recommendation() {
    }

    public Recommendation(int idRecommendation, String descriptionRecommendation, Users user) {
        this.idRecommendation = idRecommendation;
        this.descriptionRecommendation = descriptionRecommendation;
        this.user = user;
    }

    public int getIdRecommendation() {
        return idRecommendation;
    }

    public void setIdRecommendation(int idRecommendation) {
        this.idRecommendation = idRecommendation;
    }

    public String getDescriptionRecommendation() {
        return descriptionRecommendation;
    }

    public void setDescriptionRecommendation(String descriptionRecommendation) {
        this.descriptionRecommendation = descriptionRecommendation;
    }

    public Users getUsers() {
        return user;
    }

    public void setUsers(Users user) {
        this.user = user;
    }
}