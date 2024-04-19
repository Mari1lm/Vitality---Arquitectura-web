package com.example.vitality.controllers;

import com.example.vitality.dtos.AnswerDTO;
import com.example.vitality.dtos.SpecialtyDTO;
import com.example.vitality.entities.Answer;
import com.example.vitality.entities.Specialty;
import com.example.vitality.servicesinterfaces.IAnswerService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


public class AnswerController {
    private IAnswerService aS;
    @PostMapping
    public void insertar(@RequestBody AnswerDTO answerDTO){
        ModelMapper d= new ModelMapper();
        Answer answer=d.map(answerDTO,Answer.class);
        aS.insert(answer);
    }
    @GetMapping
    public List<AnswerDTO> listar(){
        return aS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,AnswerDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){

        aS.delete(id);
    }
    @GetMapping("/{id}")
    public AnswerDTO listarId(@PathVariable("id") Integer id){

        ModelMapper m= new ModelMapper();
        AnswerDTO dto=m.map(aS.listId(id),AnswerDTO.class);
        return dto;

    }
    @PutMapping
    public void modificar(@RequestBody AnswerDTO answerDTO){
        ModelMapper d= new ModelMapper();
        Answer answer=d.map(answerDTO,Answer.class);
        aS.insert(answer);
    }
}
