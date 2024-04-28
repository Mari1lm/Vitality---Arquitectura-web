package com.example.vitality.controllers;

import com.example.vitality.dtos.SpecialtyDTO;
import com.example.vitality.entities.Specialty;
import com.example.vitality.servicesinterfaces.ISpecialtyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/especialidades")

public class SpecialtyController {
    @Autowired
    private ISpecialtyService sS;
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody SpecialtyDTO specialtyDTO){
        ModelMapper d= new ModelMapper();
        Specialty specialty=d.map(specialtyDTO,Specialty.class);
        sS.insert(specialty);
    }
    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<SpecialtyDTO> listar(){
        return sS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,SpecialtyDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id){

        sS.delete(id);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public SpecialtyDTO listarId(@PathVariable("id") Integer id){

        ModelMapper m= new ModelMapper();
        SpecialtyDTO dto=m.map(sS.listId(id),SpecialtyDTO.class);
        return dto;

    }
    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody SpecialtyDTO specialtyDTO){
        ModelMapper d= new ModelMapper();
        Specialty specialty=d.map(specialtyDTO,Specialty.class);
        sS.insert(specialty);
    }
}
