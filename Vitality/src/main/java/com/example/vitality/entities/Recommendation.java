package com.example.vitality.entities;

import jakarta.persistence.*;

//FALTA USUARIO EN ATRIBUTO, SETTER GETTER Y CONSTRUCTOR
@Entity
@Table(name = "Recommendation")
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idRecommendation;

    @Column(name = "descriptionRecommendation",nullable = false,length = 200)
    public String descriptionRecommendation;

    public Recommendation() {
    }


}