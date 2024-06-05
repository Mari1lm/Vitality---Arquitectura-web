package com.example.vitality.dtos;

import com.example.vitality.entities.HealthObjective;

import java.time.LocalDate;

public class MonitoringDTO {
    private int idMonitoring;
    private LocalDate starDateMonitoring;
    private LocalDate endDateMonitoring;
    private String statusMonitoring;
    private String historyMonitoring;
    private String nutritionalPlanMonitoring;

    private HealthObjective healthObjective;
    public HealthObjective getHealthObjective() {
        return healthObjective;
    }

    public void setHealthObjective(HealthObjective healthObjective) {
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
}
