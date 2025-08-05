package com.cars.service;

import com.cars.persistence.Kupac;
import jakarta.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarPU");
        EntityManager em = emf.createEntityManager();

        Kupac kupac = new Kupac("Nenad", "Piss", "peenenad@example.com", "sir_pissalot8");

        em.getTransaction().begin();
        em.persist(kupac);
        em.getTransaction().commit();

        System.out.println("Kupac ID: " + kupac.getId());
        printKupci(em);

        em.close();
        emf.close();

    }

    private static void printKupci(EntityManager em) {
        List<Kupac> results = em.createQuery("SELECT k FROM Kupac k", Kupac.class).getResultList();
        for (Kupac k : results) {
            System.out.println(k.getName());
        }
    }
}
