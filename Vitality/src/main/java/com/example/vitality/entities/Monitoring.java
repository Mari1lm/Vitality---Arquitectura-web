package com.example.vitality.entities;

import jakarta.persistence.*;
@Entity
@Table(name = "Monitoring")
public class Monitoring {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMonitoring;
    @Column(name = "starDateMonitoring",nullable = false)
    private int starDateMonitoring;
    @Column(name = "endDateMonitoring",nullable = false)
    private int endDateMonitoring;
    @Column(name = "statusMonitoring",nullable = false,length = 100)
    private String statusMonitoring;
    @Column(name = "historyMonitoring",nullable = false,length = 300)
    private String historyMonitoring;
    @Column(name = "nutritionalPlanMonitoring",nullable = false,length = 300)
    private String nutritionalPlanMonitoring;

    public Monitoring() {
    }

    public Monitoring(int idMonitoring, int starDateMonitoring, int endDateMonitoring, String statusMonitoring, String historyMonitoring, String nutritionalPlanMonitoring) {
        this.idMonitoring = idMonitoring;
        this.starDateMonitoring = starDateMonitoring;
        this.endDateMonitoring = endDateMonitoring;
        this.statusMonitoring = statusMonitoring;
        this.historyMonitoring = historyMonitoring;
        this.nutritionalPlanMonitoring = nutritionalPlanMonitoring;
    }

    public int getIdMonitoring() {
        return idMonitoring;
    }

    public void setIdMonitoring(int idMonitoring) {
        this.idMonitoring = idMonitoring;
    }

    public int getStarDateMonitoring() {
        return starDateMonitoring;
    }

    public void setStarDateMonitoring(int starDateMonitoring) {
        this.starDateMonitoring = starDateMonitoring;
    }

    public int getEndDateMonitoring() {
        return endDateMonitoring;
    }

    public void setEndDateMonitoring(int endDateMonitoring) {
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
