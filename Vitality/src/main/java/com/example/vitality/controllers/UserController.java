package com.example.vitality.controllers;
import com.example.vitality.dtos.*;
import com.example.vitality.dtos.UserDTO;
import com.example.vitality.entities.Users;
import com.example.vitality.servicesinterfaces.IUserService;
import com.example.vitality.servicesinterfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

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
    public void insertar(@RequestBody UserDTO userDTO) {
        ModelMapper d = new ModelMapper();
        Users user = d.map(userDTO, Users.class);
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        uS.insert(user);
    }

    @PutMapping("/modificar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody UserDTO userDTO) {
        ModelMapper d = new ModelMapper();
        Users user = d.map(userDTO, Users.class);
        uS.insert(user);
    }


    @GetMapping("/listarusuarios")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<UserDTO> listar() {
        return uS.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, UserDTO.class);
        }).collect(Collectors.toList());
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id) {

        uS.delete(id);
    }

    @GetMapping("/{id} listar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public UserDTO listarId(@PathVariable("id") Integer id) {

        ModelMapper m = new ModelMapper();
        UserDTO dto = m.map(uS.listId(id), UserDTO.class);
        return dto;

    }

    @GetMapping("/find")
    @PreAuthorize("hasAuthority('ADMIN') OR hasAuthority('PROFESIONAL')" )
    public List<UserDTO> buscar(@RequestParam Float peso) {
        return uS.findByWeight(peso).stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, UserDTO.class);
        }).collect(Collectors.toList());

    }


    @GetMapping("/findbysuscription")
    @PreAuthorize("hasAuthority('ADMIN') OR hasAuthority('PROFESIONAL')" )
    public List<UserDTO> buscarporsuscripcion(@RequestParam String suscripcion) {
        return uS.findBySubscription(suscripcion).stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, UserDTO.class);
        }).collect(Collectors.toList());
    }


    @GetMapping("/findbyprofessional")
    @PreAuthorize("hasAuthority('ADMIN') OR hasAuthority('PROFESIONAL')" )
    public List<UserDTO> buscarporprofesional(@RequestParam String profesional) {
        return uS.findByHealthProfessional(profesional).stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, UserDTO.class);
        }).collect(Collectors.toList());

    }

    @GetMapping("/resumen_y_promedio_de_reseñas")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Object[]> getUsersReviewSummary() {
        return uS.getUsersReviewSummary();
    }

    @GetMapping("/Cantidaddecompras")
    @PreAuthorize("hasAuthority('ADMIN') OR hasAuthority('PROFESIONAL')" )
    public List<CountShoppingDTO> cantidaddecompras() {

        List<String[]> filaLista = uS.findCountShopping();
        List<CountShoppingDTO> dtoLista = new ArrayList<>();
        for (String[] columna : filaLista) {
            CountShoppingDTO dto = new CountShoppingDTO();
            dto.setUsername(columna[0]);
            dto.setCount(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }


    @GetMapping("/ObjetivosCompletados")
    @PreAuthorize("hasAuthority('ADMIN') OR hasAuthority('PROFESIONAL')" )
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
    }

    @GetMapping("/Usuarios_suscritos")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<ObjectiveByUsersDTO> getHealthObjectivesForSubscribedUsers() {
        List<String[]> filaLista = uS.countHealthObjectivesForSubscribedUsers();
        List<ObjectiveByUsersDTO> dtoLista = new ArrayList<>();
        for (String[] columna : filaLista) {
            ObjectiveByUsersDTO dto = new ObjectiveByUsersDTO();
            dto.setUsername(columna[0]);
            dto.setQuantity(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
