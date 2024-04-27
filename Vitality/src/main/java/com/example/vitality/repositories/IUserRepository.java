package com.example.vitality.repositories;


import com.example.vitality.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {

    public User findByNameUser(String username);
    public List<User> findByWeight (Float peso);

    public List<User> findBySubscription (String suscripcion);

    public List<User> findByHealthProfessional (String profesional);


}
