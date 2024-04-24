package com.example.vitality.controllers;

import com.example.vitality.dtos.ProductDTO;
import com.example.vitality.entities.Product;
import com.example.vitality.servicesinterfaces.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productos")
   public class ProductController {

     @Autowired
     private IProductService pS;

    @PostMapping
    public void insertar(@RequestBody ProductDTO productDTO){
        ModelMapper d= new ModelMapper();
        Product product=d.map(productDTO,Product.class);
        pS.insert(product);
    }

    @PutMapping
    public void modificar(@RequestBody ProductDTO productDTO){
        ModelMapper d= new ModelMapper();
        Product product=d.map(productDTO,Product.class);
        pS.insert(product);
    }

    @GetMapping
    public List<ProductDTO> listar(){
        return pS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,ProductDTO.class);
        }).collect(Collectors.toList());

    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){

        pS.delete(id);
    }


    @GetMapping("/{id}")
    public ProductDTO listarId(@PathVariable("id") Integer id){

        ModelMapper m= new ModelMapper();
        ProductDTO dto=m.map(pS.listId(id),ProductDTO.class);
        return dto;

    }
}
