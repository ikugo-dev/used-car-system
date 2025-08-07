package com.project.web;

import com.project.persistence.Automobil;
import com.project.service.AutomobilService;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named("carBean")
@SessionScoped
public class AutomobilBean implements Serializable {

    @Inject
    private AutomobilService automobilService;

    private List<Automobil> cars;
    private Automobil newCar = new Automobil();

    @PostConstruct
    public void init() {
        cars = automobilService.getAllCars();
    }

    public List<Automobil> getCars() {
        return cars;
    }

    public Automobil getNewCar() {
        return newCar;
    }

    public void setNewCar(Automobil newCar) {
        this.newCar = newCar;
    }

    public String addCar() {
        automobilService.addCar(newCar);
        cars = automobilService.getAllCars();
        newCar = new Automobil();
        return "index.xhtml?faces-redirect=true";
    }

    public void removeCar(Automobil car) {
        automobilService.removeCar(car);
        cars = automobilService.getAllCars();
    }

    // for testing
    public void setAutomobilService(AutomobilService automobilService) {
        this.automobilService = automobilService;
    }
}
