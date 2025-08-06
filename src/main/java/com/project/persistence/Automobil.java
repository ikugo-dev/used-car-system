package com.project.persistence;

import jakarta.persistence.*;

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

    public Automobil() {
    }

    public Automobil(String marka, String model, int godina, double cena, String prodavac) {
        this.marka = marka;
        this.model = model;
        this.godina = godina;
        this.cena = cena;
        this.prodavac = prodavac;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getProdavac() {
        return prodavac;
    }

    public void setProdavac(String prodavac) {
        this.prodavac = prodavac;
    }
}
