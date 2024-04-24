package com.example.vitality.servicesinterfaces;

import com.example.vitality.entities.Question;

import java.util.List;

public interface IQuestionService {
    public void insert(Question question);
    public List<Question> list();
    public void delete(int id);
}
