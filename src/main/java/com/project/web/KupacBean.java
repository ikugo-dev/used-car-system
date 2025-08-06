package com.project.web;

import com.project.persistence.Kupac;
import com.project.service.KupacService;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;

@Named("userBean")
@SessionScoped
public class KupacBean implements Serializable {

    private String email;
    private String lozinka;
    private String ime;
    private String prezime;

    private Kupac ulogovaniKupac;

    @Inject
    private KupacService kupacService;

    public String login() {
        Kupac kupac = kupacService.findByEmail(email);
        if (kupac != null && kupac.getSifra().equals(lozinka)) {
            this.ulogovaniKupac = kupac;
            return "index.xhtml?faces-redirect=true";
        } else {
            return "login.xhtml?error=true";
        }
    }

    public String register() {
        if (kupacService.findByEmail(email) != null) {
            return "register.xhtml?error=exists";
        }

        Kupac noviKupac = new Kupac();
        noviKupac.setEmail(email);
        noviKupac.setSifra(lozinka);
        noviKupac.setIme(ime);
        noviKupac.setPrezime(prezime);

        kupacService.addKupac(noviKupac);
        return "login.xhtml?faces-redirect=true";
    }

    public String logout() {
        this.ulogovaniKupac = null;
        return "index.xhtml?faces-redirect=true";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
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

    public Kupac getUlogovaniKupac() {
        return ulogovaniKupac;
    }

    public void setUlogovaniKupac(Kupac ulogovaniKupac) {
        this.ulogovaniKupac = ulogovaniKupac;
    }

    public KupacService getKupacService() {
        return kupacService;
    }

    public void setKupacService(KupacService kupacService) {
        this.kupacService = kupacService;
    }

}
