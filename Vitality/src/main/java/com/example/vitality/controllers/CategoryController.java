package com.example.vitality.controllers;

import com.example.vitality.dtos.AnswerDTO;
import com.example.vitality.dtos.CategoryDTO;
import com.example.vitality.dtos.UserDTO;
import com.example.vitality.entities.Category;
import com.example.vitality.entities.User;
import com.example.vitality.servicesinterfaces.ICategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categorias")
public class CategoryController {
    @Autowired
    private ICategoryService cS;

    @PostMapping
    public void insertar(@RequestBody CategoryDTO categoryDTO){
        ModelMapper d= new ModelMapper();
        Category category=d.map(categoryDTO, Category.class);
        cS.insert(category);
    }

    @PutMapping
    public void modificar(@RequestBody CategoryDTO categoryDTO){
        ModelMapper d= new ModelMapper();
        Category category=d.map(categoryDTO, Category.class);
        cS.insert(category);
    }


    @GetMapping
    public List<CategoryDTO> listar(){
        return cS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,CategoryDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        cS.delete(id);
    }


    @GetMapping("/{id}")
    public CategoryDTO listarId(@PathVariable("id") Integer id){

        ModelMapper m= new ModelMapper();
        CategoryDTO dto=m.map(cS.listId(id),CategoryDTO.class);
        return dto;

    }
}
