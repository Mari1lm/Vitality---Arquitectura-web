package com.example.vitality.servicesinterfaces;

import com.example.vitality.entities.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserService {

    public void insert(User user);
    public List<User> list();

    public void delete(int id);

    public User listId(int id);

    public List<User> findByWeight (Float peso);

    public List<User> findBySubscription (String suscripcion);

    public List<User> findByHealthProfessional (String profesional);

    public List<String[]> finUserSumProductsByType(String Type);

    public List<String[]> findCountShopping ();

    public List<String[]> findObjetiveStatus ();

}
