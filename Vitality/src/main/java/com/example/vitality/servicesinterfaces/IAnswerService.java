package com.example.vitality.servicesinterfaces;

import com.example.vitality.entities.Answer;
import com.example.vitality.entities.Specialty;

import java.util.List;

public interface IAnswerService {
    public void insert(Answer answer);
    public List<Answer> list();
    public void delete(int id);
    public Answer listId(int id);
}
