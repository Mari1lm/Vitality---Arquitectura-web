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

    @Query(value ="Select u.username,SUM(r.punctuation) FROM Users u inner join \n " +
            "            Review r on u.id = r.id_user\n " +
            "            group by u.username ",nativeQuery = true)
    List<String[]> sumPunctuations();

    // report2frank

    @Query(value ="select u.username as Usuario , sum(r.punctuation) as Suma \n" +
            "            from User u inner join Review r on \n" +
            "            u.id_udser=r.review_id \n" +
            "            group by u.username ",nativeQuery = true)
    List<String[]> totalPunctuations();



    @Query(value = "SELECT u.username AS nombre_usuario,\n " +
            "                        COUNT(r.id_review) AS total_revisiones,\n " +
            "                        AVG(r.punctuation) AS promedio_puntuacion\n " +
            "                        FROM review r \n " +
            "                        INNER JOIN users u\n " +
            "                        ON u.id = r.id_user\n " +
            "                        GROUP BY u.username ", nativeQuery = true)
    public List<String[]> findUsersReviewSummary();
}
