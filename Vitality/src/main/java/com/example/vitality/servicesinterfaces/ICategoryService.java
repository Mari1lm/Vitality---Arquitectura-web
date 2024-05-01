package com.example.vitality.servicesinterfaces;

import com.example.vitality.entities.Answer;
import com.example.vitality.entities.Category;
import com.example.vitality.servicesimplements.CategoryServiceImplement;

import java.util.List;

public interface ICategoryService {

    public void insert(Category category);

    public void delete(int id);

    public List<Category> list();

    public Category listId(int id);

    List<String> findTotalShoppingAmountToDate();

}
