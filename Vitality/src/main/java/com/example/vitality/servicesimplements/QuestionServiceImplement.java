package com.example.vitality.servicesimplements;

import com.example.vitality.entities.Product;
import com.example.vitality.entities.Question;
import com.example.vitality.repositories.IQuestionRepository;
import com.example.vitality.servicesinterfaces.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImplement implements IQuestionService{
    @Autowired
    private IQuestionRepository qR;
    @Override
    public void insert(Question question) {
        qR.save(question);
    }

    @Override
    public List<Question> list() {
        return qR.findAll();
    }

    @Override
    public void delete(int id) {
        qR.deleteById(id);
    }

    @Override
    public Question listId(int id) {
        return qR.findById(id).orElse(new Question());
    }
}
