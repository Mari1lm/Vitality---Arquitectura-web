package com.example.vitality.servicesimplements;

import com.example.vitality.entities.Resenia;
import com.example.vitality.repositories.IReseniaRepository;
import com.example.vitality.servicesinterfaces.IReseniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReseniaServiceImplement implements IReseniaService {

    @Autowired
    private IReseniaRepository rR;
    @Override
    public void insert(Resenia resenia) {
        rR.save(resenia);
    }

    @Override
    public List<Resenia> list() {
        return rR.findAll();
    }
}
