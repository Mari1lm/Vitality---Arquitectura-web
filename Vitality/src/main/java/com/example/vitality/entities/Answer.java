package com.example.vitality.entities;

import jakarta.persistence.*;

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
    private User user;



    public Answer() {
    }


    public Answer(int idAnswer, String solution, User user) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
