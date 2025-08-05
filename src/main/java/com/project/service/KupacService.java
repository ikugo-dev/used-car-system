package com.project.service;

import com.project.persistence.Kupac;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.util.List;

@Stateless
public class KupacService {

    @PersistenceContext(unitName = "CarPU")
    private EntityManager em;

    public void create(Kupac kupac) {
        em.persist(kupac);
    }

    public Kupac find(Long id) {
        return em.find(Kupac.class, id);
    }

    public List<Kupac> findAll() {
        return em.createQuery("SELECT k FROM Kupac k", Kupac.class).getResultList();
    }

    public void update(Kupac kupac) {
        em.merge(kupac);
    }

    public void delete(Long id) {
        Kupac kupac = em.find(Kupac.class, id);
        if (kupac != null) {
            em.remove(kupac);
        }
    }
}
