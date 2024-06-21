package com.example.vitality.servicesinterfaces;

import com.example.vitality.entities.Product;
import com.example.vitality.entities.Review;

import java.util.List;

public interface IReviewService {

    public void insert(Review review);
    public List<Review> list();

    public void delete(int id);

    public Review listId(int id);
    List<String[]> sumPunctuations();
    List<String[]> quantityReviewByUser();

    //reportfrank02
    List<String[]> totalPunctuations();


    public List<String[]> findUsersReviewSummary();
}
