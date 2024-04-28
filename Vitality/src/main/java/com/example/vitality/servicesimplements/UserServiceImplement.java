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
    public void insert(Users user) {
        uR.save(user);
    }

    @Override
    public List<Users> list() {
        return uR.findAll();
    }

    @Override
    public void delete(int id) {
        uR.deleteById(id);
    }

    @Override
    public Users listId(int id) {
        return uR.findById(id).orElse(new Users());
    }

    @Override
    public List<Users> findByWeight(Float peso) {
        return uR.findByWeight(peso);
    }

    @Override
    public List<Users> findBySubscription(String suscripcion) {
        return uR.findBySubscription(suscripcion);
    }

    @Override
    public List<Users> findByHealthProfessional(String profesional) {
        return uR.findByHealthProfessional(profesional);
    }

    @Override
    public List<String[]> findUsersSumProductsByType(String Type) {
        return uR.findUsersSumProductsByType(Type);
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
    public List<Object[]> getUsersReviewSummary() {
        return uR.findUsersReviewSummary();
    }

    @Override
    public List<String[]> countHealthObjectivesForSubscribedUsers() {
        return uR.countHealthObjectivesForSubscribedUsers();
    }

}
