package com.example.vitality.dtos;

import com.example.vitality.entities.Monitoring;
import com.example.vitality.entities.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class HealthObjectiveDTO {
    private int idHealthObjective;
    private String tipoObjetivo;
    private User user;

    public int getIdHealthObjective() {
        return idHealthObjective;
    }

    public void setIdHealthObjective(int idHealthObjective) {
        this.idHealthObjective = idHealthObjective;
    }

    public String getTipoObjetivo() {
        return tipoObjetivo;
    }

    public void setTipoObjetivo(String tipoObjetivo) {
        this.tipoObjetivo = tipoObjetivo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
