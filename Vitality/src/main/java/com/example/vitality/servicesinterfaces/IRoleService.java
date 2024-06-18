package com.example.vitality.servicesinterfaces;

import com.example.vitality.entities.Role;

import java.util.List;

public interface IRoleService {

    public void insert(Role rol);

    public void delete(int id);

    public Role listId(int id);

    public List<Role> list();
}
