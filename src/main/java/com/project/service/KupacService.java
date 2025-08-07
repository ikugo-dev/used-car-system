package com.project.service;

import com.project.persistence.Kupac;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
@Transactional
public class KupacService {

    private SessionFactory sessionFactory;

    @PostConstruct
    public void init() {
        sessionFactory = SessionCreator.getSessionFactory();
    }

    @PreDestroy
    public void close() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    public List<Kupac> getAllKupci() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Kupac", Kupac.class).list();
        }
    }

    public void addKupac(Kupac kupac) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(kupac);
            session.getTransaction().commit();
        }
    }

    public void removeKupac(Kupac kupac) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.remove(kupac);
            session.getTransaction().commit();
        }
    }

    public Kupac findByEmail(String email) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Kupac where email = :email", Kupac.class)
                    .setParameter("email", email)
                    .uniqueResult();
        }
    }

    public Kupac findByEmailAndPassword(String email, String sifra) {
        try (Session session = sessionFactory.openSession()) {
            return session
                    .createQuery("from Kupac where email = :email and sifra = :sifra", Kupac.class)
                    .setParameter("email", email)
                    .setParameter("sifra", sifra)
                    .uniqueResult();
        }
    }

    public void deleteDuplicateKupacByEmail(String emailToKeep) {
        try (var session = SessionCreator.getSessionFactory().openSession()) {
            session.beginTransaction();

            List<Kupac> duplicates = session
                    .createQuery("from Kupac where email = :email", Kupac.class)
                    .setParameter("email", emailToKeep)
                    .list();
            for (int i = 1; i < duplicates.size(); i++) {
                session.remove(duplicates.get(i));
            }

            session.getTransaction().commit();
        }
    }
}
