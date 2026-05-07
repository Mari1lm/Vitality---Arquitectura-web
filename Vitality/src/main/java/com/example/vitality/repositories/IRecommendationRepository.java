package com.example.vitality.repositories;

import com.example.vitality.entities.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRecommendationRepository extends JpaRepository<Recommendation,Integer> {

    //Diego
    @Query(value = "SELECT u.username AS nombre_usuario, COUNT(*) AS cant_recomendaciones " +
            "FROM recommendation r " +
            "INNER JOIN users u ON u.id = r.userid " +
            "GROUP BY u.username " +
            "ORDER BY cant_recomendaciones DESC", nativeQuery = true)
    public List<String[]> quantityRecommendationByMovie();
}
