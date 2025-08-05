package com.project.web;

import com.project.service.AutomobilService;
import com.project.persistence.Automobil;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class PregledAutomobilaBean implements Serializable {

    private List<Automobil> automobili;

    private String marka;
    private String model;
    private int godina;
    private double cena;
    private String prodavac;

    @EJB
    private AutomobilService automobilService;

    @PostConstruct
    public void init() {
        if (automobilService == null) {
            System.out.println("automobilService is null!");
            return;
        }
        automobili = automobilService.findAll();
    }

    public void save() {
        Automobil a = new Automobil(marka, model, godina, cena, prodavac);
        automobilService.create(a);
        automobili = automobilService.findAll(); // refresh list
    }

    public List<Automobil> getAutomobili() {
        return automobili;
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
