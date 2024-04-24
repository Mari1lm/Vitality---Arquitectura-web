package com.example.vitality.repositories;

import com.example.vitality.entities.ShoppingDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShoppingDetailRepository extends JpaRepository<ShoppingDetail, Integer> {
}
