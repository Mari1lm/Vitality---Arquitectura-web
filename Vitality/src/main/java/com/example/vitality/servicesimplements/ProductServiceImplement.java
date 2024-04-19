package com.example.vitality.servicesimplements;

import com.example.vitality.entities.Product;
import com.example.vitality.repositories.IProductRepository;
import com.example.vitality.servicesinterfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImplement implements IProductService {

    @Autowired
    private IProductRepository pR;
    @Override
    public void insert(Product product) {
        pR.save(product);
    }

    @Override
    public List<Product> list() {
        return pR.findAll();
    }

    @Override
    public void delete(int id) {
        pR.deleteById(id);
    }

    @Override
    public Product listId(int id) {
        return pR.findById(id).orElse(new Product());
    }
}
