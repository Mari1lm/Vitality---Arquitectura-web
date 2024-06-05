package com.example.vitality.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Role")
public class Role {

    //borrar serializable y implements en user
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRole;


    private String rol;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private Users user;

    public Role() {
    }

    public Role(int idRole, Users user) {
        this.idRole = idRole;
        this.user = user;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
