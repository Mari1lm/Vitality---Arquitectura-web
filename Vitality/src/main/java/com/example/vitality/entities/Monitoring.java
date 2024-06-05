package com.example.vitality.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Monitoring")
public class Monitoring {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMonitoring;
    @Column(name = "starDateMonitoring",nullable = false)
    private LocalDate starDateMonitoring;
    @Column(name = "endDateMonitoring",nullable = false)
    private LocalDate endDateMonitoring;
    @Column(name = "statusMonitoring",nullable = false,length = 100)
    private String statusMonitoring;
    @Column(name = "historyMonitoring",nullable = false,length = 300)
    private String historyMonitoring;
    @Column(name = "nutritionalPlanMonitoring",nullable = false,length = 300)
    private String nutritionalPlanMonitoring;

    @ManyToOne
    @JoinColumn(name = "idHealthObjective")
    private HealthObjective healthObjective;

    public Monitoring() {
    }

    public Monitoring(int idMonitoring, LocalDate starDateMonitoring, LocalDate endDateMonitoring, String statusMonitoring, String historyMonitoring, String nutritionalPlanMonitoring, HealthObjective healthObjective) {
        this.idMonitoring = idMonitoring;
        this.starDateMonitoring = starDateMonitoring;
        this.endDateMonitoring = endDateMonitoring;
        this.statusMonitoring = statusMonitoring;
        this.historyMonitoring = historyMonitoring;
        this.nutritionalPlanMonitoring = nutritionalPlanMonitoring;
        this.healthObjective = healthObjective;
    }

    public int getIdMonitoring() {
        return idMonitoring;
    }

    public void setIdMonitoring(int idMonitoring) {
        this.idMonitoring = idMonitoring;
    }

    public LocalDate getStarDateMonitoring() {
        return starDateMonitoring;
    }

    public void setStarDateMonitoring(LocalDate starDateMonitoring) {
        this.starDateMonitoring = starDateMonitoring;
    }

    public LocalDate getEndDateMonitoring() {
        return endDateMonitoring;
    }

    public void setEndDateMonitoring(LocalDate endDateMonitoring) {
        this.endDateMonitoring = endDateMonitoring;
    }

    public String getStatusMonitoring() {
        return statusMonitoring;
    }

    public void setStatusMonitoring(String statusMonitoring) {
        this.statusMonitoring = statusMonitoring;
    }

    public String getHistoryMonitoring() {
        return historyMonitoring;
    }

    public void setHistoryMonitoring(String historyMonitoring) {
        this.historyMonitoring = historyMonitoring;
    }

    public String getNutritionalPlanMonitoring() {
        return nutritionalPlanMonitoring;
    }

    public void setNutritionalPlanMonitoring(String nutritionalPlanMonitoring) {
        this.nutritionalPlanMonitoring = nutritionalPlanMonitoring;
    }

    public HealthObjective getHealthObjective() {
        return healthObjective;
    }

    public void setHealthObjective(HealthObjective healthObjective) {
        this.healthObjective = healthObjective;
    }
}
