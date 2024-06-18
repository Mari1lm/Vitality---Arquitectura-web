package com.example.vitality.repositories;

import com.example.vitality.entities.HealthObjective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHealthObjectiveRepository extends JpaRepository<HealthObjective, Integer> {

    //ITALO
    @Query(value = "SELECT u.username AS Usuarios, COUNT(*) AS Health_objectives \n " +
            "            FROM Users u\n " +
            "            INNER JOIN Health_objective h ON u.id = h.id_user\n " +
            "            GROUP BY u.username ",
            nativeQuery = true)
    List<String[]> findHealthObjectivesByUser();
}
