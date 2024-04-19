package com.example.vitality.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Specialty")


public class Specialty {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idspecialty;
    @Column( name = "specialization", nullable = false, length = 100)
    private String specialization;
    @Column( name = "profileDescription", nullable = false, length = 100)
    private String profileDescription;

    @OneToOne
    @JoinColumn(name="userId")
    private User user;

    public Specialty() {
    }

    public Specialty(int idspecialty, String specialization, String profileDescription, User user) {
        this.idspecialty = idspecialty;
        this.specialization = specialization;
        this.profileDescription = profileDescription;
        this.user = user;
    }

    public int getIdspecialty() {
        return idspecialty;
    }

    public void setIdspecialty(int idspecialty) {
        this.idspecialty = idspecialty;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
