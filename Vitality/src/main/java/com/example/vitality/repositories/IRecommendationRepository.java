package com.example.vitality.repositories;

import com.example.vitality.entities.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRecommendationRepository extends JpaRepository<Recommendation,Integer> {

    //Diego
    @Query(value = "SELECT U.username AS NOMBRE_USUARIO, COUNT(*) as Cant_Recomendaciones FROM RECOMMENDATION R \n " +
            "            INNER JOIN USERS U ON U.id = R.user_id GROUP BY U.id  ",nativeQuery = true)
    public List<String[]> quantityRecommendationByMovie();
}
