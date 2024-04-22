package com.example.vitality.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategory;
    @Column(name = "typeCategory", nullable = false, length = 20)
    private String typeCategory;

    @Column(name = "descriptionCategory", nullable = false)
    private String descriptionCategory;

    public Category() {
    }

    public Category(int idCategory, String typeCategory, String descriptionCategory) {
        this.idCategory = idCategory;
        this.typeCategory = typeCategory;
        this.descriptionCategory = descriptionCategory;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getTypeCategory() {
        return typeCategory;
    }

    public void setTypeCategory(String typeCategory) {
        this.typeCategory = typeCategory;
    }

    public String getDescriptionCategory() {
        return descriptionCategory;
    }

    public void setDescriptionCategory(String descriptionCategory) {
        this.descriptionCategory = descriptionCategory;
    }
}
