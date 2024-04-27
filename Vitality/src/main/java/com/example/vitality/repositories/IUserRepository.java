package com.example.vitality.repositories;


import com.example.vitality.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {

    public List<User> findByWeight (Float peso);

    public List<User> findBySubscription (String suscripcion);

    public List<User> findByHealthProfessional (String profesional);

    @Query(value = "SELECT u.name_user AS nombre_usuario, " +
            "COUNT(r.id_review) AS total_revisiones, " +
            "AVG(r.punctuation) AS promedio_puntuacion " +
            "FROM users u " +
            "LEFT JOIN review r " +
            "ON u.id_user = r.user_id " +
            "GROUP BY u.name_user", nativeQuery = true)
    List<Object[]> findUserReviewSummary();

}
