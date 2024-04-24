package com.example.vitality.controllers;

import com.example.vitality.dtos.CategoryDTO;
import com.example.vitality.dtos.ShoppingDetailDTO;
import com.example.vitality.entities.Category;
import com.example.vitality.entities.ShoppingDetail;
import com.example.vitality.servicesinterfaces.ICategoryService;
import com.example.vitality.servicesinterfaces.IShoppingDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/detallesCompra")
public class ShoppingDetailController {
        @Autowired
        private IShoppingDetailService sS;
        @PostMapping
        public void insertar(@RequestBody ShoppingDetailDTO shoppingDetailDTO){
            ModelMapper d= new ModelMapper();
            ShoppingDetail shoppingDetail=d.map(shoppingDetailDTO, ShoppingDetail.class);
            sS.insert(shoppingDetail);
        }

        @PutMapping
        public void modificar(@RequestBody ShoppingDetailDTO shoppingDetailDTO){
            ModelMapper d= new ModelMapper();
            ShoppingDetail shoppingDetail=d.map(shoppingDetailDTO, ShoppingDetail.class);
            sS.insert(shoppingDetail);
        }


        @GetMapping
        public List<ShoppingDetailDTO> listar(){
            return sS.list().stream().map(y->{
                ModelMapper m=new ModelMapper();
                return m.map(y,ShoppingDetailDTO.class);
            }).collect(Collectors.toList());
        }

        @DeleteMapping("/{id}")
        public void eliminar(@PathVariable("id") Integer id){
            sS.delete(id);
        }

}
