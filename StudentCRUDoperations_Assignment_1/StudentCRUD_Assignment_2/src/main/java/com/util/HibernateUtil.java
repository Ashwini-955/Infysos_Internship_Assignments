package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class HibernateUtil {

    // Hibernate Session Factory Building and return session factory using static method
    private static final SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Student.class)
            .buildSessionFactory();

    public static SessionFactory getFactory() {
        return factory;
    }
}
