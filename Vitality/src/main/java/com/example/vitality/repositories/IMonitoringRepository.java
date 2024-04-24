package com.example.vitality.repositories;

import com.example.vitality.entities.Monitoring;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMonitoringRepository extends JpaRepository<Monitoring,Integer> {
}
