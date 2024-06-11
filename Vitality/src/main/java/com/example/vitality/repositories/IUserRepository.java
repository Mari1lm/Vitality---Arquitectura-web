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

    public List<Users> findByWeight (Float peso);

    //BUSCAR POR NOMBRE
    @Query("select count(u.username) from Users u where u.username =:username")
    public int buscarUsername(@Param("username") String nombre);


    //INSERTAR ROLES
    @Transactional
    @Modifying
    @Query(value = "insert into Role (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);

}
