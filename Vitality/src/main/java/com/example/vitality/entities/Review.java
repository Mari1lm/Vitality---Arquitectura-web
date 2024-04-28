package com.example.vitality.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReview;
    @Column(name = "punctuation",nullable = false)
    private int punctuation;
    @Column(name = "comment",nullable = false,length = 200)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Users user;

    public Review() {
    }

    public Review(int idReview, int punctuation, String comment, Users user) {
        this.idReview = idReview;
        this.punctuation = punctuation;
        this.comment = comment;
        this.user = user;
    }

    public int getIdReview() {
        return idReview;
    }

    public void setIdReview(int idReview) {
        this.idReview = idReview;
    }

    public int getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(int punctuation) {
        this.punctuation = punctuation;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Users getUsers() {
        return user;
    }

    public void setUsers(Users user) {
        this.user = user;
    }
}
