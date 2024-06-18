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
}
