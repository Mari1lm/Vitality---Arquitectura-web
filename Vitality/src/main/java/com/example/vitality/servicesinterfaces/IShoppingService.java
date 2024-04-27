package com.example.vitality.servicesinterfaces;

import com.example.vitality.entities.Question;
import com.example.vitality.entities.Shopping;
import java.util.List;

public interface IShoppingService {
   public void insert(Shopping shopping);
   public List<Shopping> list();

   public void delete(int id);

   public Shopping listId(int id);
}
