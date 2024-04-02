package com.example.vitality.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.vitality.entities.Producto;
import com.example.vitality.repositories.IProductoRepository;
import com.example.vitality.servicesinterfaces.IProductoService;

import java.util.List;

@Service
public class ProductoServiceImplement implements IProductoService {
    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public void insert(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public List<Producto> list() {
        return productoRepository.findAll();
    }

    @Override
    public void delete(int id) {
        productoRepository.deleteById(id);
    }
}
