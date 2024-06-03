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

    public List<String[]> finUserSumProductsByType(String Type);
}
