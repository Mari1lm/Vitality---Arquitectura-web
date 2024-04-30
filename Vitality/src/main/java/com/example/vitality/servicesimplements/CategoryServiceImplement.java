package com.example.vitality.servicesimplements;

import com.example.vitality.entities.Category;
import com.example.vitality.repositories.ICategoryRepository;
import com.example.vitality.servicesinterfaces.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImplement implements ICategoryService {
    @Autowired
    private ICategoryRepository cR;

    @Override
    public void insert(Category category) {
        cR.save(category);
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    @Override
    public List<Category> list() {
        return cR.findAll();
    }


    @Override
    public Category listId(int id) {
        return cR.findById(id).orElse(new Category());
    }

    @Override
    public List<Object[]> findTotalIncomes() {
        return cR.findTotalIncomes();
    }
}

