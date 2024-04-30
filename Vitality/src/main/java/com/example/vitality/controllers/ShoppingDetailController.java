package com.example.vitality.controllers;

import com.example.vitality.dtos.CategoryDTO;
import com.example.vitality.dtos.ShoppingDTO;
import com.example.vitality.dtos.ShoppingDetailDTO;
import com.example.vitality.entities.Category;
import com.example.vitality.entities.ShoppingDetail;
import com.example.vitality.servicesinterfaces.ICategoryService;
import com.example.vitality.servicesinterfaces.IShoppingDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/detallesCompra")
public class ShoppingDetailController {
        @Autowired
        private IShoppingDetailService sS;
        @PostMapping
        @PreAuthorize("hasAuthority('ADMIN') OR hasAuthority('USER')")
        public void insertar(@RequestBody ShoppingDetailDTO shoppingDetailDTO){
            ModelMapper d= new ModelMapper();
            ShoppingDetail shoppingDetail=d.map(shoppingDetailDTO, ShoppingDetail.class);
            sS.insert(shoppingDetail);
        }

        @PutMapping
        @PreAuthorize("hasAuthority('ADMIN') OR hasAuthority('USER')")
        public void modificar(@RequestBody ShoppingDetailDTO shoppingDetailDTO){
            ModelMapper d= new ModelMapper();
            ShoppingDetail shoppingDetail=d.map(shoppingDetailDTO, ShoppingDetail.class);
            sS.insert(shoppingDetail);
        }


        @GetMapping
        @PreAuthorize("hasAuthority('ADMIN')")
        public List<ShoppingDetailDTO> listar(){
            return sS.list().stream().map(y->{
                ModelMapper m=new ModelMapper();
                return m.map(y,ShoppingDetailDTO.class);
            }).collect(Collectors.toList());
        }

        @DeleteMapping("/{id}")
        @PreAuthorize("hasAuthority('ADMIN') OR hasAuthority('USER')")
        public void eliminar(@PathVariable("id") Integer id){
            sS.delete(id);
        }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ShoppingDetailDTO listarId(@PathVariable("id") Integer id){

        ModelMapper m= new ModelMapper();
        ShoppingDetailDTO dto=m.map(sS.listId(id),ShoppingDetailDTO.class);
        return dto;

    }

}
