package com.example.vitality.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Role", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "nameRole"})})
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRole;

    @Column(name = "nameRole",nullable = false,length = 25)
    private String nameRole;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Role() {
    }

    public Role(int idRole, String nameRole, User user) {
        this.idRole = idRole;
        this.nameRole = nameRole;
        this.user = user;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
