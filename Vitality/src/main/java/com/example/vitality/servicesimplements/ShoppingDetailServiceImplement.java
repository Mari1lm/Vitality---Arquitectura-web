package com.example.vitality.servicesimplements;

import com.example.vitality.entities.Product;
import com.example.vitality.entities.ShoppingDetail;
import com.example.vitality.repositories.IShoppingDetailRepository;
import com.example.vitality.repositories.IShoppingRepository;
import com.example.vitality.servicesinterfaces.IShoppingDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShoppingDetailServiceImplement implements IShoppingDetailService {
    @Autowired
    private IShoppingDetailRepository sR;
    @Override
    public void insert(ShoppingDetail shoppingDetail) {
        sR.save(shoppingDetail);
    }

    @Override
    public void delete(int id) {
        sR.deleteById(id);
    }

    @Override
    public ShoppingDetail listId(int id) {
        return sR.findById(id).orElse(new ShoppingDetail());
    }

    @Override
    public List<ShoppingDetail> list() {
        return sR.findAll();
    }
}
