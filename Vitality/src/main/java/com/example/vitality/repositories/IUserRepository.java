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

    public List<Users> findByWeight (Float peso);
    public Users findByUsername(String username);

    //BUSCAR POR NOMBRE
    @Query("select count(u.username) from Users u where u.username =:username")
    public int buscarUsername(@Param("username") String nombre);

    //INSERTAR ROLES
    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") int user_id);

    //Diego
    @Query(value = "SELECT U.username as USUARIO,SUM(SD.quantity_shopping_detail) AS  TOTAL_PRODUCTOS_COMPRADOS\n" +
            "            FROM USERS U\n " +
            "            INNER JOIN SHOPPING S\n " +
            "            ON U.id = S.id_user\n " +
            "            INNER JOIN SHOPPING_DETAIL SD\n " +
            "            ON SD.num_order_shopping = S.id_shopping \n " +
            "            INNER JOIN PRODUCT PR \n " +
            "            ON PR.id_product = SD.id_product\n " +
            "            INNER JOIN CATEGORY CA\n " +
            "            ON CA.id_category = PR.category_id\n " +
            "            WHERE CA.type_category = :Tipo \n " +
            "            GROUP BY U.username ",nativeQuery = true)
    public List<String[]> finUserSumProductsByType(@Param("Tipo") String Type);

    //Michel
    @Query(value = "select u.username, count(s.id_shopping) from users u \n " +
            "            inner join shopping s on s.id_user = u.id\n " +
            "            group by u.username ", nativeQuery = true)
    public List<String[]> findCountShopping ();

    // frank?
    @Query(value = "SELECT U.username, HO.type_objective, MO.status_monitoring\n " +
            "            FROM USERS U\n " +
            "            INNER JOIN health_objective HO\n " +
            "            ON HO.id_user = U.id\n " +
            "            INNER JOIN monitoring MO\n " +
            "            ON HO.id_health_objective = MO.id_health_objective\n " +
            "            WHERE MO.status_monitoring = 'Finalizado'  ",nativeQuery = true)
    public List<String[]> findObjetiveStatus ();

    //MARI
    @Query(value = "SELECT u.username AS nombre_usuario,\n " +
            "            COUNT(r.id_review) AS total_revisiones,\n " +
            "            AVG(r.punctuation) AS promedio_puntuacion \n " +
            "            FROM users u \n " +
            "            LEFT JOIN review r\n " +
            "            ON u.id = r.id_user\n " +
            "            GROUP BY u.username ", nativeQuery = true)
    public List<Object[]> findUsersReviewSummary();

    //ITALO
    @Query(value = "SELECT u.username, COUNT(h)\n " +
            "            FROM Users u \n " +
            "            JOIN health_objective h ON h.id_user=u.id\n " +
            "            WHERE u.subscription = true \n " +
            "            GROUP BY u.id, u.username ",
            nativeQuery = true)
    List<String[]> countHealthObjectivesForSubscribedUsers();
}
