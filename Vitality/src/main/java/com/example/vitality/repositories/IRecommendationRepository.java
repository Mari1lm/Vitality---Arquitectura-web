package com.example.vitality.repositories;

import com.example.vitality.entities.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRecommendationRepository extends JpaRepository<Recommendation,Integer> {

}
