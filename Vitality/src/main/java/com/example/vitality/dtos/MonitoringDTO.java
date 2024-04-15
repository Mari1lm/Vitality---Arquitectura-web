package com.example.vitality.dtos;

public class MonitoringDTO {
    private int idMonitoring;
    private int starDateMonitoring;
    private int endDateMonitoring;
    private String statusMonitoring;
    private String historyMonitoring;
    private String nutritionalPlanMonitoring;

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
