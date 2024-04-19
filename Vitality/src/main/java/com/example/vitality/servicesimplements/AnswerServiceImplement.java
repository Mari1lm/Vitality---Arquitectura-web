package com.example.vitality.servicesimplements;

import com.example.vitality.entities.Answer;
import com.example.vitality.entities.Specialty;
import com.example.vitality.repositories.IAnswerRepository;
import com.example.vitality.repositories.ISpecialtyRepository;
import com.example.vitality.servicesinterfaces.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AnswerServiceImplement implements IAnswerService {
    @Autowired
    private IAnswerRepository aR;

    @Override
    public void insert(Answer answer) {
        aR.save(answer);
    }

    @Override
    public List<Answer> list() {
        return aR.findAll();
    }

    @Override
    public void delete(int id) {
        aR.deleteById(id);

    }

    @Override
    public Answer listId(int id) {
        return aR.findById(id).orElse(new Answer());
    }
}
