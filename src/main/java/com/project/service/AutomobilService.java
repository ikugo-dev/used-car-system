package com.project.service;

import com.project.persistence.Automobil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
@Transactional
public class AutomobilService {

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

    public List<Automobil> getAllCars() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Automobil", Automobil.class).list();
        }
    }

    public void addCar(Automobil car) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(car);
            session.getTransaction().commit();
        }
    }

    public void removeCar(Automobil car) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.remove(car);
            session.getTransaction().commit();
        }
    }
}
