package com.example.vitality.controllers;


import com.example.vitality.dtos.PunctuationByUserDTO;
import com.example.vitality.dtos.ReviewByUserDTO;
import com.example.vitality.dtos.ReviewDTO;

import com.example.vitality.entities.Review;
import com.example.vitality.servicesinterfaces.IReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/resenias")
public class ReviewController {

    @Autowired
    private IReviewService rS;

    @PostMapping
    @PreAuthorize("hasAuthority('USER')")
    public void insertar(@RequestBody ReviewDTO reviewDTO){
        ModelMapper d= new ModelMapper();
        Review review=d.map(reviewDTO,Review.class);
        rS.insert(review);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('USER')")
    public void modificar(@RequestBody ReviewDTO reviewDTO){
        ModelMapper d= new ModelMapper();
        Review review=d.map(reviewDTO,Review.class);
        rS.insert(review);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('USER')")
    public List<ReviewDTO> listar(){
        return rS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,ReviewDTO.class);
        }).collect(Collectors.toList());

    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public void eliminar(@PathVariable("id") Integer id){

        rS.delete(id);
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ReviewDTO listarId(@PathVariable("id") Integer id){

        ModelMapper m= new ModelMapper();
        ReviewDTO dto=m.map(rS.listId(id),ReviewDTO.class);
        return dto;

    }

    @GetMapping("/sumas")
    @PreAuthorize("hasAuthority('ADMIN') OR hasAuthority('USER') OR hasAuthority('PROFESIONAL')")
    public List<PunctuationByUserDTO> sumaPuntuaciones(){
        List<String[]> filaLista = rS.sumPunctuations();
        List<PunctuationByUserDTO> dtoLista=new ArrayList<>();
        for (String[] columna:filaLista){
            PunctuationByUserDTO dto=new PunctuationByUserDTO();
            dto.setUsername(columna[0]);
            dto.setSumPunctuations(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/cantidades")
    @PreAuthorize("hasAuthority('ADMIN') OR hasAuthority('USER')")
    public List<ReviewByUserDTO> cantidadReseniasUsuario(){
        List<String[]> filaLista = rS.quantityReviewByUser();
        List<ReviewByUserDTO> dtoLista=new ArrayList<>();
        for (String[] columna:filaLista){
            ReviewByUserDTO dto=new ReviewByUserDTO();
            dto.setUsername(columna[0]);
            dto.setQuantityReview(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
