package com.example.vitality.servicesimplements;

import com.example.vitality.entities.Specialty;
import com.example.vitality.repositories.ISpecialtyRepository;
import com.example.vitality.servicesinterfaces.ISpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class SpecialtyServiceImplement implements ISpecialtyService {

    @Autowired
    private ISpecialtyRepository sR;
    @Override
    public void insert(Specialty specialty) {
        sR.save(specialty);
    }

    @Override
    public List<Specialty> list() {
        return sR.findAll();
    }

    @Override
    public void delete(int id) {
        sR.deleteById(id);
    }

    @Override
    public Specialty listId(int id) {
        return sR.findById(id).orElse(new Specialty());
    }

}
