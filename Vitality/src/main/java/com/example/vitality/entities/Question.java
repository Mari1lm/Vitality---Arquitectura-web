package com.example.vitality.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idQuestion;
    @Column(name = "consulta",nullable = false,length =100)
    private String consulta;

    public Question() {
    }

    public Question(int idQuestion, String consulta) {
        this.idQuestion = idQuestion;
        this.consulta = consulta;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }
}
