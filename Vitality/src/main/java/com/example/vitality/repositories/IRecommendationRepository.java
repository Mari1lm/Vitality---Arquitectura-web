package com.example.vitality.repositories;

import com.example.vitality.entities.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRecommendationRepository extends JpaRepository<Recommendation,Integer> {

    @Query(value = "SELECT  U.id_user AS ID_USUARIO,U.name_user AS NOMBRE_USUARIO, COUNT(*) as Cant_Recomendaciones FROM RECOMMENDATION R \n " +
            "INNER JOIN USERS U ON U.id_user = R.user_id GROUP BY U.id_user ",nativeQuery = true)
    public List<String[]> quantityRecommendationByMovie();
}
