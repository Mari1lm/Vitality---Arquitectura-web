package com.example.vitality.servicesinterfaces;

import com.example.vitality.entities.Monitoring;

import java.util.List;

public interface IMonitoringService {
    public void insert(Monitoring movie);

    public List<Monitoring> list();
}
