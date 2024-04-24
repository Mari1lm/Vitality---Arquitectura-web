package com.example.vitality.servicesinterfaces;
import com.example.vitality.entities.Product;

import java.util.List;

public interface IProductService {

    public void insert(Product product);
    public List<Product> list();

    public void delete(int id);

    public Product listId(int id);
}
