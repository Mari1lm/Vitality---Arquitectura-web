package com.example.vitality.repositories;

import com.example.vitality.entities.Shopping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShoppingRepository extends JpaRepository<Shopping,Integer> {
}
