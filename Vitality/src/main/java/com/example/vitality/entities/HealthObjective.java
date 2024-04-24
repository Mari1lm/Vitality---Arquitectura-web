package com.example.vitality.entities;

import jakarta.persistence.*;

@Entity
public class HealthObjective {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHealthObjective;
    @Column(name = "typeObjective",nullable = false,length =20)
    private String typeObjective;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;


    public HealthObjective() {
    }

    public HealthObjective(int idHealthObjective, String typeObjective, User user) {
        this.idHealthObjective = idHealthObjective;
        this.typeObjective = typeObjective;
        this.user = user;
    }

    public int getIdHealthObjective() {
        return idHealthObjective;
    }

    public void setIdHealthObjective(int idHealthObjective) {
        this.idHealthObjective = idHealthObjective;
    }

    public String getTypeObjective() {
        return typeObjective;
    }

    public void setTypeObjective(String typeObjective) {
        this.typeObjective = typeObjective;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
