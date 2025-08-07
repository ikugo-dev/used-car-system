package com.project.service;

import com.project.persistence.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionCreator {
    private static SessionFactory sessionFactory;

    public static void init(String jdbcUrl) {
        try {
            Configuration config = new Configuration()
                    .addAnnotatedClass(Automobil.class)
                    .addAnnotatedClass(Kupac.class)
                    .addAnnotatedClass(Radnik.class)
                    .addAnnotatedClass(Dokument.class)
                    .setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect")
                    .setProperty("hibernate.connection.driver_class", "org.h2.Driver")
                    .setProperty("hibernate.connection.url", jdbcUrl)
                    .setProperty("hibernate.hbm2ddl.auto", "update") // or "create-drop" for tests
                    .setProperty("hibernate.show_sql", "false");

            sessionFactory = config.buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize Hibernate SessionFactory", e);
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            init("jdbc:h2:./data/carDB;AUTO_SERVER=TRUE");
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
            sessionFactory = null;
        }
    }
}
// .addAnnotatedClass(Automobil.class)
// .addAnnotatedClass(Kupac.class)
// .addAnnotatedClass(Radnik.class)
// .setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect")
// .setProperty("hibernate.connection.driver_class", "org.h2.Driver")
// .setProperty("hibernate.connection.url",
// "jdbc:h2:./data/carDB;AUTO_SERVER=TRUE")
// .setProperty("hibernate.hbm2ddl.auto", "update")
// .setProperty("hibernate.show_sql", "true")
// .buildSessionFactory();
//
