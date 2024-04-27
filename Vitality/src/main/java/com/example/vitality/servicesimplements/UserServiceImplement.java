package com.example.vitality.servicesimplements;

import com.example.vitality.entities.User;
import com.example.vitality.repositories.IUserRepository;
import com.example.vitality.servicesinterfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplement implements IUserService {

    @Autowired
private IUserRepository uR;

    @Override
    public void insert(User user) {
        uR.save(user);
    }

    @Override
    public List<User> list() {
        return uR.findAll();
    }

    @Override
    public void delete(int id) {
        uR.deleteById(id);
    }

    @Override
    public User listId(int id) {
        return uR.findById(id).orElse(new User());
    }

    @Override
    public List<User> findByWeight(Float peso) {
        return uR.findByWeight(peso);
    }

    @Override
    public List<User> findBySubscription(String suscripcion) {
        return uR.findBySubscription(suscripcion);
    }

    @Override
    public List<User> findByHealthProfessional(String profesional) {
        return uR.findByHealthProfessional(profesional);
    }




}
