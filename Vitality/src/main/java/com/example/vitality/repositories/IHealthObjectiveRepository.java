package com.example.vitality.repositories;

import com.example.vitality.entities.HealthObjective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHealthObjectiveRepository extends JpaRepository<HealthObjective, Integer> {

}
