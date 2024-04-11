package com.example.vitality.repositories;

import com.example.vitality.entities.Resenia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReseniaRepository extends JpaRepository<Resenia,Integer> {
}
