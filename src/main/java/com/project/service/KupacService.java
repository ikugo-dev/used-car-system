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
}
