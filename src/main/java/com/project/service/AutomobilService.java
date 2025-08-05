package com.project.service;

import com.project.persistence.Automobil;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.util.List;

@Stateless
public class AutomobilService {

    @PersistenceContext(unitName = "CarPU")
    private EntityManager em;

    public void create(Automobil automobil) {
        em.persist(automobil);
    }

    public Automobil find(Long id) {
        return em.find(Automobil.class, id);
    }

    public List<Automobil> findAll() {
        return em.createQuery("SELECT a FROM Automobil a", Automobil.class).getResultList();
    }

    public void update(Automobil automobil) {
        em.merge(automobil);
    }

    public void delete(Long id) {
        Automobil a = em.find(Automobil.class, id);
        if (a != null) {
            em.remove(a);
        }
    }
}
