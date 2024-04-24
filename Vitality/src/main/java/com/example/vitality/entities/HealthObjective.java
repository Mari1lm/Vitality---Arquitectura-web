package com.example.vitality.entities;

import jakarta.persistence.*;

@Entity
public class HealthObjective {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHealthObjective;
    @Column(name = "tipoObjetivo",nullable = false,length =20)
    private String tipoObjetivo;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "monitoringId")
    private Monitoring monitoring;

    public HealthObjective() {
    }

    public HealthObjective(int idHealthObjective, String tipoObjetivo, User user, Monitoring monitoring) {
        this.idHealthObjective = idHealthObjective;
        this.tipoObjetivo = tipoObjetivo;
        this.user = user;
        this.monitoring = monitoring;
    }

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

    public Monitoring getMonitoring() {
        return monitoring;
    }

    public void setMonitoring(Monitoring monitoring) {
        this.monitoring = monitoring;
    }
}
