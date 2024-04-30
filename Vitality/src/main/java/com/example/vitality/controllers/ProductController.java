package com.example.vitality.controllers;

import com.example.vitality.dtos.ProductDTO;
import com.example.vitality.entities.Product;
import com.example.vitality.servicesinterfaces.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/productos")
   public class ProductController {

     @Autowired
     private IProductService pS;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody ProductDTO productDTO){
        ModelMapper d= new ModelMapper();
        Product product=d.map(productDTO,Product.class);
        pS.insert(product);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody ProductDTO productDTO){
        ModelMapper d= new ModelMapper();
        Product product=d.map(productDTO,Product.class);
        pS.insert(product);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN') OR hasAuthority('USER') OR hasAuthority('PROFESIONAL')")
    public List<ProductDTO> listar(){
        return pS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,ProductDTO.class);
        }).collect(Collectors.toList());

    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id){

        pS.delete(id);
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public ProductDTO listarId(@PathVariable("id") Integer id){

        ModelMapper m= new ModelMapper();
        ProductDTO dto=m.map(pS.listId(id),ProductDTO.class);
        return dto;

    }
}