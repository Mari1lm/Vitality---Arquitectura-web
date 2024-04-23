package com.example.vitality.repositories;

import com.example.vitality.entities.Monitoring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMonitoringRepository extends JpaRepository <Monitoring,Integer> {
    //assa
}
