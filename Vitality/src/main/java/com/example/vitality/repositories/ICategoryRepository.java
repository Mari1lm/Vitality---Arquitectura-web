package com.example.vitality.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.vitality.entities.Category;

import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Integer> {
    @Query(value = "SELECT 'Cantidad total en compras a la fecha: ' || SUM(total_shopping) AS Total_shopping\n" +
            "FROM Shopping;",
            nativeQuery = true)
    List<String> findTotalShoppingAmountToDate();
}
