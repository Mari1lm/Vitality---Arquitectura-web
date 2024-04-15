package com.example.vitality.repositories;

import com.example.vitality.entities.Shopping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShoppingRepository extends JpaRepository<Shopping,Integer> {
}
