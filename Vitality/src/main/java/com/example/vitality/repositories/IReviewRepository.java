package com.example.vitality.repositories;


import com.example.vitality.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReviewRepository extends JpaRepository<Review,Integer> {
    //Michel
    @Query(value ="select u.username as Usuarios, count(*) as Reviews \n" +
            "            from Users u inner join Review r \n" +
            "            on u.id = r.id_user\n" +
            "            group by u.username",nativeQuery = true)
    List<String[]> quantityReviewByUser();

    // frank?
    @Query(value = "SELECT SUM(r.punctuation) FROM Review r", nativeQuery = true)
    Integer sumPunctuations();

    // report2frank
    @Query(value ="select u.username as Usuario , sum(r.punctuation) as Suma \n" +
            "            from Users u inner join Review r on \n" +
            "            u.id = r.id_user \n" +
            "            group by u.username ",nativeQuery = true)
    List<String[]> totalPunctuations();



    @Query(value = "SELECT u.username AS nombre_usuario, " +
            "COUNT(r.id_review) AS total_resenas " +
            "FROM review r " +
            "INNER JOIN users u ON u.id = r.id_user " +
            "GROUP BY u.username " +
            "ORDER BY total_resenas DESC", nativeQuery = true)
    public List<String[]> findUsersReviewSummary();
}
