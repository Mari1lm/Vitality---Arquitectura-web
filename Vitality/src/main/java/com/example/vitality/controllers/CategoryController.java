package com.example.vitality.controllers;

import com.example.vitality.dtos.AnswerDTO;
import com.example.vitality.dtos.CategoryDTO;
import com.example.vitality.dtos.UserDTO;
import com.example.vitality.entities.Category;
import com.example.vitality.entities.Users;
import com.example.vitality.servicesinterfaces.ICategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categorias")
public class CategoryController {
    @Autowired
    private ICategoryService cS;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody CategoryDTO categoryDTO){
        ModelMapper d= new ModelMapper();
        Category category=d.map(categoryDTO, Category.class);
        cS.insert(category);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody CategoryDTO categoryDTO){
        ModelMapper d= new ModelMapper();
        Category category=d.map(categoryDTO, Category.class);
        cS.insert(category);
    }


    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN') OR hasAuthority('USER') OR hasAuthority('PROFESIONAL')")
    public List<CategoryDTO> listar(){
        return cS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,CategoryDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id){
        cS.delete(id);
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public CategoryDTO listarId(@PathVariable("id") Integer id) {

        ModelMapper m = new ModelMapper();
        CategoryDTO dto = m.map(cS.listId(id), CategoryDTO.class);
        return dto;
    }

    @GetMapping("/Ingresos_totales")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Object[]> getIncomesByMonthAndCategory() {
        return cS.findTotalIncomes();
    }
}
