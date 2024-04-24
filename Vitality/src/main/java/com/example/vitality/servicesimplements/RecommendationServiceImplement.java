package com.example.vitality.servicesimplements;

import com.example.vitality.entities.Recommendation;
import com.example.vitality.repositories.IRecommendationRepository;
import com.example.vitality.servicesinterfaces.IRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecommendationServiceImplement implements IRecommendationService {
    @Autowired
    private IRecommendationRepository rR;
    @Override
    public void insert(Recommendation recommendation){rR.save(recommendation);}
    @Override
    public List<Recommendation> list(){return rR.findAll(); }
    @Override
    public void delete(int id){rR.deleteById(id);}

    @Override
    public List<String[]> quantityRecommendationByMovie(){return rR.quantityRecommendationByMovie();}
}
