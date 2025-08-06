package com.project.persistence;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Radnik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ime;
    private String prezime;
    @OneToMany
    private List<Automobil> automobiliUDodavanju;

    public Radnik() {
    }

    public Radnik(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public List<Automobil> getAutomobiliUDodavanju() {
        return automobiliUDodavanju;
    }

    public void setAutomobiliUDodavanju(List<Automobil> automobiliUDodavanju) {
        this.automobiliUDodavanju = automobiliUDodavanju;
    }

}
