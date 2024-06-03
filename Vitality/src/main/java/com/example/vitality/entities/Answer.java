package com.example.vitality.entities;

import jakarta.persistence.*;
import org.apache.catalina.User;

@Entity
@Table(name="Answer")

public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAnswer;
    @Column( name = "answer", nullable = false, length = 100)
    private String solution;
    @ManyToOne
    @JoinColumn(name="userId")
    private Users user;



    public Answer() {
    }


    public Answer(int idAnswer, String solution, Users user) {
        this.idAnswer = idAnswer;
        this.solution = solution;
        this.user = user;

    }

    public int getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(int idAnswer) {
        this.idAnswer = idAnswer;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

}
