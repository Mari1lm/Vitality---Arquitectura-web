package com.example.vitality.servicesimplements;

import com.example.vitality.entities.Users;
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
    public void insert(Users usuario) {
        uR.save(usuario);
    }

    @Override
    public List<Users> list() {
        return uR.findAll();
    }

    @Override
    public void delete(int idUsuario) {
        uR.deleteById(idUsuario);
    }

    @Override
    public Users listarId(int idUsuario) {
        return uR.findById(idUsuario).orElse(new Users());
    }

    @Override
    public List<Users> findByWeight(Float peso) {
        return uR.findByWeight(peso);
    }


    @Override
    public List<String[]> findCountShopping() {
        return uR.findCountShopping();
    }

    @Override
    public List<String[]> findObjetiveStatus() {
        return uR.findObjetiveStatus();
    }

    @Override
    public List<Object[]> findUsersReviewSummary() {
        return uR.findUsersReviewSummary();
    }

    @Override
    public List<String[]> countHealthObjectivesForSubscribedUsers() {
        return uR.countHealthObjectivesForSubscribedUsers();
    }


}
