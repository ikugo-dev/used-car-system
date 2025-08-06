package com.project.service;

import com.project.persistence.Automobil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class AutomobilService {

    private SessionFactory sessionFactory;

    @PostConstruct
    public void init() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Automobil.class)
                .setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect")
                .setProperty("hibernate.connection.driver_class", "org.h2.Driver")
                .setProperty("hibernate.connection.url", "jdbc:h2:./data/carDB;AUTO_SERVER=TRUE") // ("jdbc:h2:mem:testdb")
                .setProperty("hibernate.hbm2ddl.auto", "update")
                .setProperty("hibernate.show_sql", "true")
                .buildSessionFactory();
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
