package com.example.vitality.controllers;
import com.example.vitality.dtos.CountShoppingDTO;
import com.example.vitality.dtos.StatusObjetiveDTO;
import com.example.vitality.dtos.UserDTO;
import com.example.vitality.entities.User;
import com.example.vitality.servicesinterfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void insertar(@RequestBody UserDTO userDTO) {
        ModelMapper d = new ModelMapper();
        User user = d.map(userDTO, User.class);
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        uS.insert(user);
    }

    @PutMapping("/modificar")
    public void modificar(@RequestBody UserDTO userDTO) {
        ModelMapper d = new ModelMapper();
        User user = d.map(userDTO, User.class);
        uS.insert(user);
    }


    @GetMapping("/listarusuarios")
    public List<UserDTO> listar() {
        return uS.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, UserDTO.class);
        }).collect(Collectors.toList());
    }


    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {

        uS.delete(id);
    }

    @GetMapping("/{id} listar")
    public UserDTO listarId(@PathVariable("id") Integer id) {

        ModelMapper m = new ModelMapper();
        UserDTO dto = m.map(uS.listId(id), UserDTO.class);
        return dto;

    }

    @GetMapping("/find")
    public List<UserDTO> buscar(@RequestParam Float peso) {
        return uS.findByWeight(peso).stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, UserDTO.class);
        }).collect(Collectors.toList());

    }


    @GetMapping("/findbysuscription")
    public List<UserDTO> buscarporsuscripcion(@RequestParam String suscripcion) {
        return uS.findBySubscription(suscripcion).stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, UserDTO.class);
        }).collect(Collectors.toList());
    }


    @GetMapping("/findbyprofessional")
    public List<UserDTO> buscarporprofesional(@RequestParam String profesional) {
        return uS.findByHealthProfessional(profesional).stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, UserDTO.class);
        }).collect(Collectors.toList());

    }

    @GetMapping("/resumen_y_promedio_de_reseñas")
    public List<Object[]> getUserReviewSummary() {
        return uS.getUserReviewSummary();
    }

    @GetMapping("/Cantidaddecompras")
    public List<CountShoppingDTO> cantidaddecompras() {

        List<String[]> filaLista = uS.findCountShopping();
        List<CountShoppingDTO> dtoLista = new ArrayList<>();
        for (String[] columna : filaLista) {
            CountShoppingDTO dto = new CountShoppingDTO();
            dto.setNameUser(columna[0]);
            dto.setCount(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }


    @GetMapping("/ObjetivosCompletados")
    public List<StatusObjetiveDTO> objetivoscompletados() {

        List<String[]> filaLista = uS.findObjetiveStatus();
        List<StatusObjetiveDTO> dtoLista = new ArrayList<>();
        for (String[] columna : filaLista) {
            StatusObjetiveDTO dto = new StatusObjetiveDTO();
            dto.setNameUser(columna[0]);
            dto.setTypeObjetive(columna[1]);
            dto.setStatus(columna[2]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
