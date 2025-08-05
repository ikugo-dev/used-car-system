package com.cars.persistence;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Radnik extends Osoba {

    // Add specific Radnik fields or methods here
    // For now, it's empty, just inherit from Osoba

    public Radnik() {
        super();
    }

    public Radnik(String ime, String prezime, Integer godine, Long jmbg) {
        super(ime, prezime, godine, jmbg);
    }

    @OneToMany
    private List<Automobil> automobili; // cars the worker can manage

    public List<Automobil> getAutomobili() {
        return automobili;
    }

    public void setAutomobili(List<Automobil> automobili) {
        this.automobili = automobili;
    }
}
