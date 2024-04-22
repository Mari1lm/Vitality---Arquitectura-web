package com.example.vitality.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;

    @Column(name = "nameRol",nullable = false,length = 25)
    private String nameRol;

    public Rol() {
    }

    public Rol(int idRol, String nameRol) {
        this.idRol = idRol;
        this.nameRol = nameRol;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNameRol() {
        return nameRol;
    }

    public void setNameRol(String nameRol) {
        this.nameRol = nameRol;
    }
}
