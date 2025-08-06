package com.project.service;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.persistence.*;

public class SessionCreator {
    private static final SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Automobil.class)
                .addAnnotatedClass(Kupac.class)
                .addAnnotatedClass(Radnik.class)
                .setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect")
                .setProperty("hibernate.connection.driver_class", "org.h2.Driver")
                .setProperty("hibernate.connection.url", "jdbc:h2:./data/carDB;AUTO_SERVER=TRUE")
                .setProperty("hibernate.hbm2ddl.auto", "update")
                .setProperty("hibernate.show_sql", "true")
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
