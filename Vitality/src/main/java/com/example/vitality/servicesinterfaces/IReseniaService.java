package com.example.vitality.servicesinterfaces;

import com.example.vitality.entities.Resenia;

import java.util.List;

public interface IReseniaService {

    public void insert(Resenia resenia);
    public List<Resenia> list();

}
