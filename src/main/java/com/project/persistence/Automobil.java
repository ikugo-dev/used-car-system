package com.project.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Automobil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marka;
    private String model;
    private int godina;
    private double cena;
    private String prodavac;

    // Getters and setters omitted for brevity

    // Constructor(s)
    public Automobil() {
    }

    public Automobil(String marka, String model, int godina, double cena, String prodavac) {
        this.marka = marka;
        this.model = model;
        this.godina = godina;
        this.cena = cena;
        this.prodavac = prodavac;
    }

}
