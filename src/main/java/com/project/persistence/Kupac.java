package com.project.persistence;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Kupac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    private String ime;

    public String getName() {
        return ime + " " + prezime;
    }

    private String prezime;
    private String email;
    private String sifra;

    // Constructors, getters, setters

    public Kupac() {
    }

    public Kupac(String ime, String prezime, String email, String sifra) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.sifra = sifra;
    }

    @OneToMany
    private List<Automobil> automobili; // cars the customer is interested in (or owns)

    public List<Automobil> getAutomobili() {
        return automobili;
    }

    public void setAutomobili(List<Automobil> automobili) {
        this.automobili = automobili;
    }
    // Getters and setters...
}
