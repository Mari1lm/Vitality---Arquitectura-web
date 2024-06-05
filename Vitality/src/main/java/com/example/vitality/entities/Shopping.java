package com.example.vitality.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Shopping")
public class Shopping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idShopping;
    @Column(name = "dateShopping",nullable = false)
    private LocalDate dateShopping;
    @Column(name = "totalShopping",nullable = false)
    private int totalShopping;
    @ManyToOne
    @JoinColumn(name = "idUser")
    private Users user;

    public Shopping() {

    }

    public Shopping(int idShopping, LocalDate dateShopping, int totalShopping, Users user) {
        this.idShopping = idShopping;
        this.dateShopping = dateShopping;
        this.totalShopping = totalShopping;
        this.user = user;
    }

    public int getIdShopping() {
        return idShopping;
    }

    public void setIdShopping(int idShopping) {
        this.idShopping = idShopping;
    }

    public LocalDate getDateShopping() {
        return dateShopping;
    }

    public void setDateShopping(LocalDate dateShopping) {
        this.dateShopping = dateShopping;
    }

    public int getTotalShopping() {
        return totalShopping;
    }

    public void setTotalShopping(int totalShopping) {
        this.totalShopping = totalShopping;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }


}
