package com.example.vitality.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Resenia")
public class Resenia {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int idResenia;
     @Column(name = "puntuacion",nullable = false)
     private int puntuacion;
     @Column(name = "comentario",nullable = false,length = 60)
     private String  comentario;

    public Resenia() {
    }

    public Resenia(int idResenia, int puntuacion, String comentario) {
        this.idResenia = idResenia;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
    }

    public int getIdResenia() {
        return idResenia;
    }

    public void setIdResenia(int idResenia) {
        this.idResenia = idResenia;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
