package com.example.vitality.controllers;

import com.example.vitality.dtos.RecommendationDTO;
import com.example.vitality.dtos.RecommendationByUserDTO;
import com.example.vitality.dtos.RecommendationDTO;
import com.example.vitality.entities.Recommendation;
import com.example.vitality.entities.Recommendation;
import com.example.vitality.servicesinterfaces.IRecommendationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recomendaciones")
public class RecommendationController {
    @Autowired
    private IRecommendationService rS;

    @PostMapping
    @PreAuthorize("hasAuthority('PROFESIONAL')")
    public void insertar(@RequestBody RecommendationDTO recommendationDTO){
        ModelMapper m = new ModelMapper();
        Recommendation r = m.map(recommendationDTO, Recommendation.class);
        rS.insert(r);

    }
    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN') OR hasAuthority('USER') OR hasAuthority('PROFESIONAL')")
    public List<RecommendationDTO> listar(){
        return rS.list().stream().map(y-> {
            ModelMapper m = new ModelMapper();
            return m.map(y, RecommendationDTO.class);
        }).collect(Collectors.toList());
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN') OR hasAuthority('PROFESIONAL')")
    public void eliminar(@PathVariable("id") int id){rS.delete(id);}

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN') OR hasAuthority('PROFESIONAL')")
    public RecommendationDTO listarId(@PathVariable("id") Integer id){

        ModelMapper m= new ModelMapper();
        RecommendationDTO dto=m.map(rS.listId(id),RecommendationDTO.class);
        return dto;

    }
    @PutMapping
    @PreAuthorize("hasAuthority('PROFESIONAL') OR hasAuthority('ADMIN')")
    public void modificar(@RequestBody RecommendationDTO recommendationDTO){
        ModelMapper d= new ModelMapper();
        Recommendation recommendation=d.map(recommendationDTO,Recommendation.class);
        rS.insert(recommendation);
    }

    @GetMapping("/cantidadesporUsuario")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<RecommendationByUserDTO> cantidadRecomendacionesporUsuario(){
        List<String[]> filaLista = rS.quantityRecommendationByMovie();
        List<RecommendationByUserDTO> dtoLista = new ArrayList<>();
        for(String[] columna:filaLista){
            RecommendationByUserDTO dto = new RecommendationByUserDTO();
            dto.setIdUser(Integer.parseInt(columna[0]));
            dto.setUsername(columna[1]);
            dto.setQuantityRecommendation(Integer.parseInt(columna[2]));
            dtoLista.add(dto);
        }
        return dtoLista;


    }

}
