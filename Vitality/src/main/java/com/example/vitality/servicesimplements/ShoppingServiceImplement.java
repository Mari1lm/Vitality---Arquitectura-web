package com.example.vitality.servicesimplements;
import com.example.vitality.entities.Shopping;
import com.example.vitality.repositories.IShoppingRepository;
import com.example.vitality.servicesinterfaces.IShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingServiceImplement implements IShoppingService {
    //dsa
    @Autowired
    private IShoppingRepository sR;
    @Override
    public void insert(Shopping shopping) {
        sR.save(shopping);
    }

    @Override
    public List<Shopping> list() {
        return sR.findAll();
    }

}
