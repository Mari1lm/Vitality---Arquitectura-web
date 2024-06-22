package com.example.vitality.servicesinterfaces;

import com.example.vitality.entities.HealthObjective;

import java.util.List;

public interface IHealthObjectiveService {
    public void insert(HealthObjective healthObjective);
    public List<HealthObjective> list();
    public void delete(int id);
    public HealthObjective listId(int id);
    List<String[]> findHealthObjectivesByUser();
    public List<String[]> countHealthObjectivesForSubscribedUsers();

    public List<String[]> findObjetiveStatus ();
}
