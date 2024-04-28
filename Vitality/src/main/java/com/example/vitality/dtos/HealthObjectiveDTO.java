package com.example.vitality.dtos;

import com.example.vitality.entities.Monitoring;
import com.example.vitality.entities.Users;
import com.example.vitality.entities.Users;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class HealthObjectiveDTO {
    private int idHealthObjective;
    private String tipoObjetivo;
    private Users user;

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

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

}
