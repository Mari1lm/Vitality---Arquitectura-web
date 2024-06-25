package com.example.vitality.controllers;
import com.example.vitality.dtos.RoleDTO;
import com.example.vitality.entities.Role;
import com.example.vitality.servicesinterfaces.IRoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private IRoleService rS;


    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody RoleDTO roleDTO){
        ModelMapper d= new ModelMapper();
        Role role=d.map(roleDTO, Role.class);
        rS.insert(role);
    }


    @PutMapping
    public void modificar(@RequestBody RoleDTO roleDTO){
        ModelMapper d= new ModelMapper();
        Role role=d.map(roleDTO, Role.class);
        rS.insert(role);
    }



    @GetMapping
    public List<RoleDTO> listar(){
        return rS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,RoleDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        rS.delete(id);
    }

    @GetMapping("/{id}")
    public RoleDTO listarId(@PathVariable("id") int id){

        ModelMapper m= new ModelMapper();
        RoleDTO dto=m.map(rS.listId(id),RoleDTO.class);
        return dto;

    }
    
}
