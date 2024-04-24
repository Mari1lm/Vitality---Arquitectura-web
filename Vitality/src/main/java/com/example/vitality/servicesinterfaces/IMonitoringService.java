package com.example.vitality.servicesinterfaces;

import com.example.vitality.entities.Answer;
import com.example.vitality.entities.Monitoring;

import java.util.List;

public interface IMonitoringService {
    public void insert(Monitoring movie);

    public List<Monitoring> list();

    public void delete(int id);

    public Monitoring listId(int id);
}
