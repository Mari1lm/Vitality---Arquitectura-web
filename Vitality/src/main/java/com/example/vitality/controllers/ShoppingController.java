package com.example.vitality.controllers;

import com.example.vitality.dtos.ShoppingDTO;
import com.example.vitality.entities.Shopping;
import com.example.vitality.servicesinterfaces.IShoppingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/compras")
public class ShoppingController {
    @Autowired
    private IShoppingService sS;

    @PostMapping
    @PreAuthorize("hasAuthority('USER')")
    public void insertar(@RequestBody ShoppingDTO shoppingDTO) {
        ModelMapper d = new ModelMapper();
        Shopping shopping = d.map(shoppingDTO, Shopping.class);

    }
    @PutMapping@PreAuthorize("hasAuthority('USER') OR hasAuthority('ADMIN')")
    public void modificar(@RequestBody ShoppingDTO shoppingDTO){
        ModelMapper d= new ModelMapper();
        Shopping shopping=d.map(shoppingDTO, Shopping.class);
        sS.insert(shopping);
    }


    @GetMapping@PreAuthorize("hasAuthority('ADMIN')")
    public List<ShoppingDTO> listar(){
        return sS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,ShoppingDTO.class);
        }).collect(Collectors.toList());
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('USER') OR hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id){
        sS.delete(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ShoppingDTO listarId(@PathVariable("id") Integer id){

            ModelMapper m = new ModelMapper();
            ShoppingDTO dto = m.map(sS.listId(id), ShoppingDTO.class);
            return dto;

        }
}
