package com.example.vitality.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "/ShoppingDetail")
public class ShoppingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idShoppingDetail;
    @Column(name = "quantityShoppingDetail",nullable = false)
    private int quantityShoppingDetail;
    @Column(name = "subtotalShoppingDetail",nullable = false)
    private float subtotalShoppingDetail;

    @ManyToOne
    @JoinColumn(name = "idProduct")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "numOrderShopping")
    private Shopping shopping;

    public ShoppingDetail() {
    }

    public ShoppingDetail(int idShoppingDetail, int quantityShoppingDetail, float subtotalShoppingDetail, Product product, Shopping shopping) {
        this.idShoppingDetail = idShoppingDetail;
        this.quantityShoppingDetail = quantityShoppingDetail;
        this.subtotalShoppingDetail = subtotalShoppingDetail;
        this.product = product;
        this.shopping = shopping;
    }

    public int getIdShoppingDetail() {
        return idShoppingDetail;
    }

    public void setIdShoppingDetail(int idShoppingDetail) {
        this.idShoppingDetail = idShoppingDetail;
    }

    public int getQuantityShoppingDetail() {
        return quantityShoppingDetail;
    }

    public void setQuantityShoppingDetail(int quantityShoppingDetail) {
        this.quantityShoppingDetail = quantityShoppingDetail;
    }

    public float getSubtotalShoppingDetail() {
        return subtotalShoppingDetail;
    }

    public void setSubtotalShoppingDetail(float subtotalShoppingDetail) {
        this.subtotalShoppingDetail = subtotalShoppingDetail;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Shopping getShopping() {
        return shopping;
    }

    public void setShopping(Shopping shopping) {
        this.shopping = shopping;
    }
}
