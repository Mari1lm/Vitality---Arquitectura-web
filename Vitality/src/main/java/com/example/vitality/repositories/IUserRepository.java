package com.example.vitality.repositories;


import com.example.vitality.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {

    @Query(value = "SELECT U.name_user as USUARIO,SUM(S.total_shopping) AS  TOTAL_PRODUCTOS_COMPRADOS \n " +
            "FROM USERS U \n " +
            "INNER JOIN SHOPPING S \n " +
            "ON U.id_user = S.user_id\n " +
            "INNER JOIN PRODUCT PR \n " +
            "ON PR.id_product = S.producto_id\n " +
            "INNER JOIN CATEGORY CA\n " +
            "ON CA.id_category = PR.category_id\n " +
            "WHERE CA.type_category = %:Tipo%\n " +
            "GROUP BY U.name_user ",nativeQuery = true)
    public List<String[]> finUserSumProductsByType(@Param("Tipo") String Type);

    public List<User> findByWeight (Float peso);

    public List<User> findBySubscription (String suscripcion);

    public List<User> findByHealthProfessional (String profesional);
}
