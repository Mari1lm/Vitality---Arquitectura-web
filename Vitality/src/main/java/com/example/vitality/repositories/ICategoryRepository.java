package com.example.vitality.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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


    //DIEGO (MODIFICADO DE USUARIO)
    @Query(value = "SELECT PR.\"name\" AS PRODUCTO, SUM(SD.quantity_shopping_detail) AS TOTAL_PRODUCTOS_COMPRADOS\n " +
            "            FROM CATEGORY CA\n " +
            "            INNER JOIN PRODUCT PR\n " +
            "            ON PR.category_id = CA.id_category\n " +
            "            INNER JOIN SHOPPING_DETAIL SD\n " +
            "            ON SD.id_product = PR.id_product\n " +
            "            INNER JOIN SHOPPING S\n " +
            "            ON SD.id_product = PR.id_product\n " +
            "            INNER JOIN USERS U\n " +
            "            ON U.id = S.id_user\n " +
            "            WHERE CA.type_category = :Tipo \n " +
            "            GROUP BY PR.\"name\" ",nativeQuery = true)
    List<String[]> ProductsByCategory(@Param("Tipo") String type);
}