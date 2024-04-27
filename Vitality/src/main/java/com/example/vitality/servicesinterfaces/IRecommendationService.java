package com.example.vitality.servicesinterfaces;

import com.example.vitality.entities.Question;
import com.example.vitality.entities.Recommendation;

import java.util.List;

public interface IRecommendationService {
     public void insert(Recommendation recommendation);
     public List<Recommendation> list();

     public void delete(int id);

     public Recommendation listId(int id);

     public List<String[]> quantityRecommendationByMovie();
}
