package com.example.vitality.servicesimplements;


import com.example.vitality.entities.HealthObjective;
import com.example.vitality.repositories.IHealthObjectiveRepository;
import com.example.vitality.servicesinterfaces.IHealthObjectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthObjectiveServiceImplement implements IHealthObjectiveService {

    @Autowired
    private IHealthObjectiveRepository hR;
    @Override
    public void insert(HealthObjective healthObjective) {
        hR.save(healthObjective);
    }

    @Override
    public List<HealthObjective> list() {
        return hR.findAll();
    }

    @Override
    public void delete(int id) {
        hR.deleteById(id);
    }

    @Override
    public HealthObjective listId(int id) {
        return hR.findById(id).orElse(new HealthObjective());

    }
}
