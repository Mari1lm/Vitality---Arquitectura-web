package com.example.vitality.controllers;

import com.example.vitality.dtos.QuestionDTO;
import com.example.vitality.entities.Question;
import com.example.vitality.servicesinterfaces.IQuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/preguntas")
public class QuestionController {
    @Autowired
    private IQuestionService qS;
    @PostMapping
    public void insertar (@RequestBody QuestionDTO questionDTO){
        ModelMapper d = new ModelMapper();
        Question question = d.map(questionDTO, Question.class);
        qS.insert(question);
    }
    @GetMapping
    public List<QuestionDTO> listar(){
        return qS.list().stream().map(y-> {
            ModelMapper m =new ModelMapper();
            return m.map(y, QuestionDTO.class);
                }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id){
        qS.delete(id);
    }
}
