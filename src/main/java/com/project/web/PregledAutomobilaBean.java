package com.project.web;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("carBean")
@SessionScoped
public class PregledAutomobilaBean implements Serializable {

    private List<String> cars;
    private String newCar;

    @PostConstruct
    public void init() {
        cars = new ArrayList<>();
        cars.add("Toyota Corolla");
        cars.add("Ford Focus");
        cars.add("Honda Civic");
    }

    public List<String> getCars() {
        return cars;
    }

    public String getNewCar() {
        return newCar;
    }

    public void setNewCar(String newCar) {
        this.newCar = newCar;
    }

    public String addCar() {
        if (newCar != null && !newCar.trim().isEmpty()) {
            cars.add(newCar.trim());
            newCar = ""; // clear input
        }
        return null; // stay on the same page
    }

    public String removeCar(String car) {
        cars.remove(car);
        return null;
    }
}
