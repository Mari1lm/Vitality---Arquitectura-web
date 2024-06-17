package com.example.vitality.servicesinterfaces;

import com.example.vitality.entities.Role;

import java.util.List;

public interface IRoleService {

    public void insert(Role rol);

    public void delete(Long id);

    public Role listId(Long id);

    public List<Role> list();
}
