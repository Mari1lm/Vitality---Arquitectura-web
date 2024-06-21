package com.example.vitality.servicesimplements;

import com.example.vitality.entities.Product;
import com.example.vitality.entities.Review;
import com.example.vitality.repositories.IReviewRepository;
import com.example.vitality.servicesinterfaces.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImplement implements IReviewService {

    @Autowired
    private IReviewRepository rR;
    @Override
    public void insert(Review review) {
        rR.save(review);
    }

    @Override
    public List<Review> list() {
        return rR.findAll();
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    @Override
    public Review listId(int id) {
        return rR.findById(id).orElse(new Review());
    }

    @Override
    public List<String[]> sumPunctuations() {
        return rR.sumPunctuations();
    }

    @Override
    public List<String[]> quantityReviewByUser() {
        return rR.quantityReviewByUser();
    }

    //frankreport2
    @Override
    public List<String[]> totalPunctuations() {
        return rR.totalPunctuations();
    }

    @Override
    public List<String[]> findUsersReviewSummary() {
        return rR.findUsersReviewSummary();
    }
}
