package com.example.vitality.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Shopping")
public class Shopping {
    //fdsfd
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numOrderShopping;
    @Column(name = "dateShopping",nullable = false)
    private int dateShopping;
    @Column(name = "totalShopping",nullable = false)
    private int totalShopping;
    @Column(name = "idUserShopping",nullable = false)
    private int idUserShopping;
    @Column(name = "IdProductShopping",nullable = false)
    private int IdProductShopping;

    public Shopping() {
    }

    public Shopping(int numOrderShopping, int dateShopping, int totalShopping, int idUserShopping, int idProductShopping) {
        this.numOrderShopping = numOrderShopping;
        this.dateShopping = dateShopping;
        this.totalShopping = totalShopping;
        this.idUserShopping = idUserShopping;
        IdProductShopping = idProductShopping;
    }

    public int getNumOrderShopping() {
        return numOrderShopping;
    }

    public void setNumOrderShopping(int numOrderShopping) {
        this.numOrderShopping = numOrderShopping;
    }

    public int getDateShopping() {
        return dateShopping;
    }

    public void setDateShopping(int dateShopping) {
        this.dateShopping = dateShopping;
    }

    public int getTotalShopping() {
        return totalShopping;
    }

    public void setTotalShopping(int totalShopping) {
        this.totalShopping = totalShopping;
    }

    public int getIdUserShopping() {
        return idUserShopping;
    }

    public void setIdUserShopping(int idUserShopping) {
        this.idUserShopping = idUserShopping;
    }

    public int getIdProductShopping() {
        return IdProductShopping;
    }

    public void setIdProductShopping(int idProductShopping) {
        IdProductShopping = idProductShopping;
    }
}
