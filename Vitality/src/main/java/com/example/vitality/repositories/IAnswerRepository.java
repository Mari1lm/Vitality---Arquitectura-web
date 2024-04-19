package com.example.vitality.repositories;

import com.example.vitality.entities.Answer;
import com.example.vitality.entities.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IAnswerRepository extends JpaRepository<Answer, Integer> {

}
