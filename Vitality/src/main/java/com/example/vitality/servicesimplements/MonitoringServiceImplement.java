package com.example.vitality.servicesimplements;

import com.example.vitality.entities.Monitoring;
import com.example.vitality.entities.Product;
import com.example.vitality.repositories.IMonitoringRepository;
import com.example.vitality.servicesinterfaces.IMonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitoringServiceImplement implements IMonitoringService {

    @Autowired
    private IMonitoringRepository mR;
    @Override
    public void insert(Monitoring monitoring){
        mR.save(monitoring);
    }
    @Override
    public List<Monitoring> list(){
        return mR.findAll();
    }

    @Override
    public void delete(int id) {
        mR.deleteById(id);
    }

    @Override
    public Monitoring listId(int id) {
        return mR.findById(id).orElse(new Monitoring());
    }
}
