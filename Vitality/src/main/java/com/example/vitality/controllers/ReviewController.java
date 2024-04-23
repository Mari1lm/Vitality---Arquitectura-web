package com.example.vitality.controllers;


import com.example.vitality.dtos.ReviewDTO;

import com.example.vitality.entities.Review;
import com.example.vitality.servicesinterfaces.IReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/resenias")
public class ReviewController {

    @Autowired
    private IReviewService rS;

    @PostMapping
    public void insertar(@RequestBody ReviewDTO reviewDTO){
        ModelMapper d= new ModelMapper();
        Review review=d.map(reviewDTO,Review.class);
        rS.insert(review);
    }

    @PutMapping
    public void modificar(@RequestBody ReviewDTO reviewDTO){
        ModelMapper d= new ModelMapper();
        Review review=d.map(reviewDTO,Review.class);
        rS.insert(review);
    }

    @GetMapping
    public List<ReviewDTO> listar(){
        return rS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,ReviewDTO.class);
        }).collect(Collectors.toList());

    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){

        rS.delete(id);
    }


    @GetMapping("/{id}")
    public ReviewDTO listarId(@PathVariable("id") Integer id){

        ModelMapper m= new ModelMapper();
        ReviewDTO dto=m.map(rS.listId(id),ReviewDTO.class);
        return dto;

    }
}
