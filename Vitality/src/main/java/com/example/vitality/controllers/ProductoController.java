package com.example.vitality.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.vitality.dtos.ProductoDTO;
import com.example.vitality.entities.Producto;
import com.example.vitality.servicesinterfaces.IProductoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private IProductoService productoService;

    @PostMapping
    public void insertar(@RequestBody ProductoDTO productoDTO){
        ModelMapper modelMapper = new ModelMapper();
        Producto producto = modelMapper.map(productoDTO, Producto.class);
        productoService.insert(producto);
    }

    @GetMapping
    public List<ProductoDTO> listar(){
        return productoService.list().stream().map(producto -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(producto, ProductoDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable  Integer id){

        productoService.delete(id);
    }
}