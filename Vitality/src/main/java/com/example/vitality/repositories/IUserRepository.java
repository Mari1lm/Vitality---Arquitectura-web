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




}
