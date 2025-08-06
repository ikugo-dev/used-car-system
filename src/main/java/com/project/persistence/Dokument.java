package com.project.persistence;

import jakarta.persistence.*;

@Entity
public class Dokument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv;
    private String tip;
    private String sadrzaj;

    public Dokument() {
    }

    public Dokument(String naziv, String tip, String sadrzaj) {
        this.naziv = naziv;
        this.tip = tip;
        this.sadrzaj = sadrzaj;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

}
