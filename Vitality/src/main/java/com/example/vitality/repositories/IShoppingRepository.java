package com.example.vitality.repositories;

import com.example.vitality.entities.Shopping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IShoppingRepository extends JpaRepository<Shopping,Integer> {
    @Query(value = "select u.username, count(s.id_shopping) from shopping s \n " +
            "                        inner join users u on u.id = s.id_user \n " +
            "                        group by u.username ", nativeQuery = true)
    public List<String[]> findCountShopping ();

}
