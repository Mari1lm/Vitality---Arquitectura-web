package com.example.vitality.repositories;


import com.example.vitality.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<Users,Integer> {

    public Users findByUsername(String username);


    public List<Users> findByWeight (Float peso);

    public List<Users> findBySubscription (String suscripcion);

    public List<Users> findByHealthProfessional (String profesional);


    @Query(value = "select u.username, count(s.num_order_shopping) from users u \n " +
            "inner join shopping s on s.user_id = u.id_user \n " +
            "group by u.username ", nativeQuery = true)
    public List<String[]> findCountShopping ();

    @Query(value = "SELECT U.username, HO.type_objective, MO.status_monitoring\n " +
            "FROM USERS U\n " +
            "INNER JOIN health_objective HO\n " +
            "ON HO.user_id = U.id_user\n " +
            "INNER JOIN monitoring MO\n " +
            "ON HO.id_health_objective = MO.id_health_objective\n " +
            "WHERE MO.status_monitoring = 'Finalizado' ",nativeQuery = true)
    public List<String[]> findObjetiveStatus ();
    @Query(value = "SELECT u.username AS nombre_usuario, " +
            "COUNT(r.id_review) AS total_revisiones, " +
            "AVG(r.punctuation) AS promedio_puntuacion " +
            "FROM users u " +
            "LEFT JOIN review r " +
            "ON u.id_user = r.user_id " +
            "GROUP BY u.username", nativeQuery = true)
    List<Object[]> findUsersReviewSummary();

    //INSERTAR ROLES
    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);


    @Query(value = "SELECT U.username as USUARIO,SUM(SD.quantity_shopping_detail) AS  TOTAL_PRODUCTOS_COMPRADOS\n " +
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
            "GROUP BY U.username  ",nativeQuery = true)
    List<String[]> findUsersSumProductsByType(@Param("Tipo") String type);
}
