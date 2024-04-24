package com.example.vitality.controllers;

import com.example.vitality.dtos.UserDTO;
import com.example.vitality.entities.User;
import com.example.vitality.servicesinterfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UserController {
@Autowired
private IUserService uS;

    @PostMapping
    public void insertar(@RequestBody UserDTO userDTO){
        ModelMapper d= new ModelMapper();
        User user=d.map(userDTO,User.class);
        uS.insert(user);
    }

    @PutMapping
    public void modificar(@RequestBody UserDTO userDTO){
        ModelMapper d= new ModelMapper();
        User user=d.map(userDTO,User.class);
        uS.insert(user);
    }


    @GetMapping
    public List<UserDTO> listar(){
        return uS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,UserDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){

        uS.delete(id);
    }

    @GetMapping("/{id}")
    public UserDTO listarId(@PathVariable("id") Integer id){

        ModelMapper m= new ModelMapper();
        UserDTO dto=m.map(uS.listId(id),UserDTO.class);
        return dto;

    }

    @GetMapping("/find")
    public List<UserDTO> buscar(@RequestParam Float peso){
        return uS.findByWeight(peso).stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,UserDTO.class);
        }).collect(Collectors.toList());

    }


    @GetMapping("/findbysuscription")
    public List<UserDTO> buscarporsuscripcion(@RequestParam String suscripcion){
        return uS.findBySubscription(suscripcion).stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,UserDTO.class);
        }).collect(Collectors.toList());

    }

    @GetMapping("/findbyprofessional")
    public List<UserDTO> buscarporprofesional(@RequestParam String profesional){
        return uS.findByHealthProfessional(profesional).stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,UserDTO.class);
        }).collect(Collectors.toList());

    }


}
