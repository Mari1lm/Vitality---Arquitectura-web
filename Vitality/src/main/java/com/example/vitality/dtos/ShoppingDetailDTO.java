package com.example.vitality.dtos;

import com.example.vitality.entities.Product;
import com.example.vitality.entities.Shopping;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ShoppingDetailDTO {
    private int idShoppingDetail;
    private int quantityShoppingDetail;
    private float subtotalShoppingDetail;

    private Product product;

    private Shopping shopping;

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
