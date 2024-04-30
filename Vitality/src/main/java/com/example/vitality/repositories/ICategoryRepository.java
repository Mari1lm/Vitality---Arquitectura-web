package com.example.vitality.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.vitality.entities.Category;

import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Integer> {
    @Query(value = "SELECT EXTRACT(MONTH FROM TO_DATE(s.dateShopping::text, 'YYYYMMDD')) AS mes, " +
            "SUM(s.totalShopping) AS ingresos " +
            "FROM Shopping s " +
            "GROUP BY EXTRACT(MONTH FROM TO_DATE(s.dateShopping::text, 'YYYYMMDD'))", nativeQuery = true)
    List<Object[]> findTotalIncomes();
}
