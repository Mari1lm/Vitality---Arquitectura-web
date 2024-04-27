package com.example.vitality.repositories;

import com.example.vitality.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionRepository extends JpaRepository<Question,Integer> {
}
