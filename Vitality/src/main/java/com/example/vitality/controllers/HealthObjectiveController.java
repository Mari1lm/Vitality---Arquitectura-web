package com.example.vitality.controllers;

import com.example.vitality.dtos.AnswerDTO;
import com.example.vitality.dtos.HealthObjectiveDTO;
import com.example.vitality.entities.Answer;
import com.example.vitality.entities.HealthObjective;
import com.example.vitality.servicesinterfaces.IHealthObjectiveService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/Objetivo-de-salud")
public class HealthObjectiveController {
    @Autowired
    private IHealthObjectiveService hS;
    @PostMapping
    @PreAuthorize("hasAnyAuthority('CLIENTE','PROFESIONAL')")
    public void insertar(@RequestBody HealthObjectiveDTO healthObjectiveDTO){
        ModelMapper d= new ModelMapper();
        HealthObjective healthObjective =d.map(healthObjectiveDTO,HealthObjective.class);
        hS.insert(healthObjective);
    }
    @GetMapping
    public List<HealthObjectiveDTO> listar(){
        return hS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,HealthObjectiveDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){

        hS.delete(id);
    }
    @GetMapping("/{id}")
    public HealthObjectiveDTO listarId(@PathVariable("id") Integer id){

        ModelMapper m= new ModelMapper();
        HealthObjectiveDTO dto=m.map(hS.listId(id),HealthObjectiveDTO.class);
        return dto;

    }

    @PutMapping
    public void modificar(@RequestBody HealthObjectiveDTO healthObjectiveDTO){
        ModelMapper d= new ModelMapper();
        HealthObjective healthObjective=d.map(healthObjectiveDTO,HealthObjective.class);
        hS.insert(healthObjective);
    }
}
