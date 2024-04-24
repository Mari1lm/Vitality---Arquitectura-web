package com.example.vitality.servicesinterfaces;

import com.example.vitality.entities.Question;
import com.example.vitality.entities.ShoppingDetail;

import java.util.List;

public interface IShoppingDetailService {
    public void insert(ShoppingDetail shoppingDetail);

    public void delete(int id);

    public ShoppingDetail listId(int id);

    public List<ShoppingDetail> list();
}
