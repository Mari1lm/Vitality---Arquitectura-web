package com.example.vitality.servicesinterfaces;

import com.example.vitality.entities.User;

import java.util.List;

public interface IUserService {

    public void insert(User user);
    public List<User> list();

    public void delete(int id);

    public User listId(int id);

    public List<User> findByWeight (Float peso);

    public List<User> findBySubscription (String suscripcion);

    public List<User> findByHealthProfessional (String profesional);
}
