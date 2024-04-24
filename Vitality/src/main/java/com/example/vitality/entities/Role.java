package com.example.vitality.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRole;

    @Column(name = "nameRole",nullable = false,length = 25)
    private String nameRole;

    public Role() {
    }

    public Role(int idRole, String nameRole) {
        this.idRole = idRole;
        this.nameRole = nameRole;
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
}
