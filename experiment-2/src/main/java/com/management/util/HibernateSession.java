package com.management.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by nicholas on 5/16/17.
 */
public class HibernateSession {
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();
    private static       Session        session = factory.openSession();

    public static Session getSession() {
        if (session == null) {
            session = factory.openSession();
        }
        return session;
    }
}
