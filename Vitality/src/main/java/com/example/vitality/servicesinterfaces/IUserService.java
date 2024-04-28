package com.example.vitality.servicesinterfaces;

import com.example.vitality.entities.Users;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserService {

    public void insert(Users user);
    public List<Users> list();

    public void delete(int id);

    public Users listId(int id);

    public List<Users> findByWeight (Float peso);

    public List<Users> findBySubscription (String suscripcion);

    public List<Users> findByHealthProfessional (String profesional);

    public List<String[]> findUsersSumProductsByType(String Type);

    public List<String[]> findCountShopping ();

    public List<String[]> findObjetiveStatus ();

    List<Object[]> getUsersReviewSummary();

    List<String[]> countHealthObjectivesForSubscribedUsers();

}
