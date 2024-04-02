package com.example.vitality.servicesinterfaces;

import com.example.vitality.entities.Producto;

import java.util.List;

public interface IProductoService {
    void insert(Producto producto);
    public List<Producto> list();

    public void delete(int id);
}
