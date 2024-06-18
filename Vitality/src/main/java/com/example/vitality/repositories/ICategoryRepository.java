package com.example.vitality.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.vitality.entities.Category;

import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Integer> {

    // Michel
    @Query(value = "SELECT 'Cantidad total en compras a la fecha: ' || SUM(total_shopping) AS Total_shopping\n " +
            "            FROM Shopping; ",
            nativeQuery = true)
    List<String> findTotalShoppingAmountToDate();

    //Mari
    @Query(value = "SELECT EXTRACT(MONTH FROM TO_DATE(s.date_shopping::text, 'YYYYMMDD')) AS mes,\n " +
            "c.type_category AS categoria_producto,\n " +
            "SUM(s.total_shopping) AS ingresos\n " +
            "FROM Shopping s \n " +
            "INNER JOIN shopping_detail sd ON sd.num_order_shopping = s.id_shopping\n " +
            "INNER JOIN Product p ON sd.id_product = p.id_product\n " +
            "INNER JOIN Category c ON p.category_id = c.id_category \n " +
            "GROUP BY EXTRACT(MONTH FROM TO_DATE(s.date_shopping::text, 'YYYYMMDD')), c.type_category ",
            nativeQuery = true)
    List<Object[]> findIncomesByMonthAndCategory();
}
