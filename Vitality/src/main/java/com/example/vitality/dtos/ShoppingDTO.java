package com.example.vitality.dtos;

public class ShoppingDTO {
    private int numOrderShopping;
    private int dateShopping;
    private int totalShopping;
    private int idUserShopping;
    private int IdProductShopping;

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
