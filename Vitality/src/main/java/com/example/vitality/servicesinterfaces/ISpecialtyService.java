package com.example.vitality.servicesinterfaces;

import com.example.vitality.entities.Specialty;

import java.util.List;

public interface ISpecialtyService {
    public void insert(Specialty specialty);
    public List<Specialty> list();
    public void delete(int id);
    public Specialty listId(int id);
}
