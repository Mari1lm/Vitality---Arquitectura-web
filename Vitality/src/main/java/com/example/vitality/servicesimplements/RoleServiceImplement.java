package com.example.vitality.servicesimplements;

import com.example.vitality.entities.Product;
import com.example.vitality.entities.Role;
import com.example.vitality.repositories.IRoleRepository;
import com.example.vitality.servicesinterfaces.IRoleService;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImplement implements IRoleService {
    @Autowired
    private IRoleRepository rR;
    @Override
    public void insert(Role role) {
        rR.save(role);
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    @Override
    public Role listId(int id) {
        return rR.findById(id).orElse(new Role());
    }

    @Override
    public List<Role> list() {
        return rR.findAll();
    }

    @Override
    public Role listarId(int id) {
        return rR.findById(id).orElse(new Role());
    }
}
