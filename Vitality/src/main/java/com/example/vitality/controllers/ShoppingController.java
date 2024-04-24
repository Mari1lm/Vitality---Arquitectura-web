package com.example.vitality.controllers;

//import com.example.vitality.dtos.ShoppingDTO;
//import com.example.vitality.entities.Shopping;
//import com.example.vitality.servicesinterfaces.IShoppingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.stream.Collectors;

public class ShoppingController {
    /*@Autowired
    private IShoppingService sS;

    @PostMapping
    public void insertar(@RequestBody ShoppingDTO shoppingDTO) {
        ModelMapper d = new ModelMapper();
        Shopping shopping = d.map(shoppingDTO, Shopping.class);
        sS.insert(movie);
    }

    @GetMapping
    public List<ShoppingDTO> listar() {
        return sS.list().stream().map(y-> {
            ModelMapper m=new ModelMapper();
            return  m.map(y,ShoppingDTO.class);
        }).collect(Collectors.toList());
    }*/
}
