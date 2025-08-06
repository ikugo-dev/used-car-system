package com.project.service;

import com.project.persistence.Radnik;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
@Transactional
public class RadnikService {

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

    public List<Radnik> getAllRadnici() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Radnik", Radnik.class).list();
        }
    }

    public void addRadnik(Radnik radnik) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(radnik);
            session.getTransaction().commit();
        }
    }

    public void removeRadnik(Radnik radnik) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.remove(radnik);
            session.getTransaction().commit();
        }
    }
}
