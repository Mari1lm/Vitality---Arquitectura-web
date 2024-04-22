package com.example.vitality.repositories;

import com.example.vitality.entities.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRecommendationRepository extends JpaRepository<Recommendation,Integer> {

    //public List<String[]> quantityRecommendationByMovie();
}
