package com.example.vitality.servicesinterfaces;

import com.example.vitality.entities.Shopping;
import java.util.List;

public interface IShoppingService {
   //fsa
   public void insert(Shopping shopping);
   public List<Shopping> list();
}
