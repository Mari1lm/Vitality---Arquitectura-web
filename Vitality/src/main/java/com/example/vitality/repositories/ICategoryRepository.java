package com.example.vitality.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.vitality.entities.Category;

import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Integer> {

    // MARI
    @Query(value = "SELECT EXTRACT(YEAR FROM date_shopping) AS year, " +
            "COUNT(*) AS total_shoppings " +
            "FROM Shopping " +
            "WHERE total_shopping IS NOT NULL " +
            "GROUP BY EXTRACT(YEAR FROM date_shopping) " +
            "ORDER BY year;",
            nativeQuery = true)
    List<String> findTotalShoppingAmountToDate();
}