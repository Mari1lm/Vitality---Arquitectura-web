package com.example.vitality.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idRol;

    @Column(name = "nameRol",nullable = false,length = 25)
    public String nameRol;
}
