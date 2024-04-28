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
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody RoleDTO roleDTO){
        ModelMapper d= new ModelMapper();
        Role role=d.map(roleDTO, Role.class);
        rS.insert(role);
    }


    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<RoleDTO> listar(){
        return rS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,RoleDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id){
        rS.delete(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public RoleDTO listarId(@PathVariable("id") Integer id){

        ModelMapper m= new ModelMapper();
        RoleDTO dto=m.map(rS.listarId(id),RoleDTO.class);
        return dto;

    }
}
