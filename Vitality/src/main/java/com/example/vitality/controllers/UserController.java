
package com.example.vitality.controllers;
import com.example.vitality.dtos.*;
import com.example.vitality.entities.Users;
import com.example.vitality.servicesinterfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private IUserService uS;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody UserDTO userDTO){
        ModelMapper m = new ModelMapper();
        Users u = m.map(userDTO, Users.class);
        String encodedPassword = passwordEncoder.encode(u.getPassword());
        u.setPassword(encodedPassword);
        uS.insert(u);
    }

    @PutMapping
    public void modificar(@RequestBody UserDTO userDTO){
        ModelMapper d= new ModelMapper();
        Users category=d.map(userDTO, Users.class);
        uS.insert(category);
    }


    @GetMapping
    public List<UserDTO> listar(){
        return uS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,UserDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        uS.delete(id);
    }


    @GetMapping("/{id}")
    public UserDTO listarId(@PathVariable("id") int id){

        ModelMapper m= new ModelMapper();
        UserDTO dto=m.map(uS.listarId(id),UserDTO.class);
        return dto;

    }

    @GetMapping("/finda")
    public List<UserDTO> buscar(@RequestParam Float peso){
        return uS.findByWeight(peso).stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,UserDTO.class);
        }).collect(Collectors.toList());

    }

        @GetMapping("/resumen_y_promedio_de_resenas")
        @PreAuthorize("hasAuthority('ADMIN')")
        public List<PunctuationByUserDTO> getUsersReviewSummary() {
            List<String[]> rawList = uS.findUsersReviewSummary();
            List<PunctuationByUserDTO> dtoList = new ArrayList<>();
            for (String[] row : rawList) {
                PunctuationByUserDTO dto = new PunctuationByUserDTO();
                dto.setUsername(row[0]);
                dto.setSumPunctuations(Integer.parseInt( row[1]));
                dto.setAverageReview(Double.parseDouble(row[2]));
                dtoList.add(dto);
            }

            return dtoList;
        }
    }

    /*@GetMapping("/Cantidaddecompras")
    public List<CountShoppingDTO> cantidaddecompras() {

        List<String[]> filaLista = uS.findCountShopping();
        List<CountShoppingDTO> dtoLista = new ArrayList<>();
        for (String[] columna : filaLista) {
            CountShoppingDTO dto = new CountShoppingDTO();
            dto.setDateShopping(LocalDate.parse((String) columna[0]));
            dto.setCount(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }/*


   /* @GetMapping("/ObjetivosCompletados")
    public List<StatusObjetiveDTO> objetivoscompletados() {

        List<String[]> filaLista = uS.findObjetiveStatus();
        List<StatusObjetiveDTO> dtoLista = new ArrayList<>();
        for (String[] columna : filaLista) {
            StatusObjetiveDTO dto = new StatusObjetiveDTO();
            dto.setUsername(columna[0]);
            dto.setTypeObjetive(columna[1]);
            dto.setStatus(columna[2]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }}*/

