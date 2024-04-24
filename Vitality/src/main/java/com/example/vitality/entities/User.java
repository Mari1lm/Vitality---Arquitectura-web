package com.example.vitality.entities;

import jakarta.persistence.*;

    @Entity
    @Table(name="User")
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idUser;
        @Column(name = "nameUser",nullable = false,length = 50)
        private String nameUser;
        @Column(name = "email",nullable = false,length = 100)
        private String email;
        @Column(name = "password",nullable = false,length = 20)
        private String password;
        @Column(name = "address",nullable = false,length = 100)

        private String address;
        @Column(name = "weight",nullable = false)
        private Float weight;
        @Column(name = "height",nullable = false)
        private int height;
        @Column(name = "subscription",nullable = false,length = 10)
        private String subscription;
        @Column(name = "healthProfessional",nullable = false,length = 10)
        private String healthProfessional;
        /*@ManyToOne
        @JoinColumn(name = "rolId")
        private Rol rol;*/

        public User() {
        }

        public User(int idUser, String nameUser, String email, String password, String address, Float weight, int height, String subscription, String healthProfessional) {
            this.idUser = idUser;
            this.nameUser = nameUser;
            this.email = email;
            this.password = password;
            this.address = address;
            this.weight = weight;
            this.height = height;
            this.subscription = subscription;
            this.healthProfessional = healthProfessional;
            //this.rol = rol;
        }

        public int getIdUser() {
            return idUser;
        }

        public void setIdUser(int idUser) {
            this.idUser = idUser;
        }

        public String getNameUser() {
            return nameUser;
        }

        public void setNameUser(String nameUser) {
            this.nameUser = nameUser;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Float getWeight() {
            return weight;
        }

        public void setWeight(Float weight) {
            this.weight = weight;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getSubscription() {
            return subscription;
        }

        public void setSubscription(String subscription) {
            this.subscription = subscription;
        }

        public String getHealthProfessional() {
            return healthProfessional;
        }

        public void setHealthProfessional(String healthProfessional) {
            this.healthProfessional = healthProfessional;
        }

       /* public Rol getRol() {
            return rol;
        }

        public void setRol(Rol rol) {
            this.rol = rol;
        }*/
    }
