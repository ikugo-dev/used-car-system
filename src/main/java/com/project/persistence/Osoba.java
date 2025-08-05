package com.project.persistence;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Osoba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ime;
    private String prezime;
    private Integer godine;
    private Long jmbg; // or String if you prefer

    // Constructors, getters, setters
    public Osoba() {
    }

    public Osoba(String ime, String prezime, Integer godine, Long jmbg) {
        this.ime = ime;
        this.prezime = prezime;
        this.godine = godine;
        this.jmbg = jmbg;
    }

    // Getters and setters...
}
