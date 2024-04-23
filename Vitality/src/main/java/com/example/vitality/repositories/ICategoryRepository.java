package com.example.vitality.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.vitality.entities.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Integer> {

}
