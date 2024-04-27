package com.example.vitality.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.vitality.entities.Category;

import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Integer> {
    @Query(value = "SELECT EXTRACT(MONTH FROM TO_DATE(s.dateShopping::text, 'YYYYMMDD')) AS mes, " +
            "c.typeCategory AS categoria_producto, " +
            "SUM(s.totalShopping) AS ingresos " +
            "FROM Shopping s " +
            "INNER JOIN Product p ON s.productoId = p.id_product " +
            "INNER JOIN Category c ON p.category_id = c.id_category " +
            "GROUP BY EXTRACT(MONTH FROM TO_DATE(s.dateShopping::text, 'YYYYMMDD')), c.typeCategory",
            nativeQuery = true)
    List<Object[]> findIncomesByMonthAndCategory();
}
