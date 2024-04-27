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

    @Query(value = "SELECT U.name_user as USUARIO,SUM(SD.quantity_shopping_detail) AS  TOTAL_PRODUCTOS_COMPRADOS\n " +
            "FROM USERS U\n " +
            "INNER JOIN SHOPPING S\n " +
            "ON U.id_user = S.user_id\n " +
            "INNER JOIN SHOPPING_DETAIL SD\n " +
            "ON SD.num_order_shopping = S.num_order_shopping\n " +
            "INNER JOIN PRODUCT PR\n " +
            "ON PR.id_product = SD.id_product\n " +
            "INNER JOIN CATEGORY CA\n " +
            "ON CA.id_category = PR.category_id\n " +
            "WHERE CA.type_category = :Tipo\n " +
            "GROUP BY U.name_user  ",nativeQuery = true)

    public List<String[]> finUserSumProductsByType(@Param("Tipo") String Type);

    public List<User> findByWeight (Float peso);

    public List<User> findBySubscription (String suscripcion);

    public List<User> findByHealthProfessional (String profesional);

    @Query(value = "select u.name_user, count(s.num_order_shopping) from users u \n " +
            "inner join shopping s on s.user_id = u.id_user \n " +
            "group by u.name_user ", nativeQuery = true)
    public List<String[]> findCountShopping ();

    @Query(value = "SELECT U.name_user, HO.type_objective, MO.status_monitoring\n " +
            "FROM USERS U\n " +
            "INNER JOIN health_objective HO\n " +
            "ON HO.user_id = U.id_user\n " +
            "INNER JOIN monitoring MO\n " +
            "ON HO.id_health_objective = MO.id_health_objective\n " +
            "WHERE MO.status_monitoring = 'Finalizado' ",nativeQuery = true)
    public List<String[]> findObjetiveStatus ();
}
