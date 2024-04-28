package com.example.vitality.repositories;

import com.example.vitality.entities.HealthObjective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHealthObjectiveRepository extends JpaRepository<HealthObjective, Integer> {
    @Query(value = "SELECT u.username AS Usuarios, COUNT(*) AS Health_objectives " +
            "FROM Users u " +
            "INNER JOIN Health_objective h ON u.id_user = h.id_user " +
            "GROUP BY u.username",
            nativeQuery = true)
    List<String[]> findHealthObjectivesByUser();

}
