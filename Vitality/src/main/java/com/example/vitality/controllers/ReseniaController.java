package com.example.vitality.controllers;

import com.example.vitality.dtos.ReseniaDTO;
import com.example.vitality.entities.Resenia;
import com.example.vitality.servicesinterfaces.IReseniaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/resenias")
public class ReseniaController {

    @Autowired
    private IReseniaService rS;

    @PostMapping
    public void insertar(@RequestBody ReseniaDTO reseniaDTO){
        ModelMapper d= new ModelMapper();
        Resenia resenia=d.map(reseniaDTO,Resenia.class);
        rS.insert(resenia);
    }

    @GetMapping
    public List<ReseniaDTO> listar(){
        return rS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,ReseniaDTO.class);
        }).collect(Collectors.toList());

    }

}
