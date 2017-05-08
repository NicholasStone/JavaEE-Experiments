package com.twodogs.dao;

import com.twodogs.model.Model;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by nicholas on 5/3/17.
 */
public abstract class Dao {
    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    protected List findAll(String string) {
        Session     session     = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List        list        = session.createQuery(string).list();
        transaction.commit();
        session.close();
        return list;
    }

    public String add(Model model) {
        Session     session     = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String      uuid        = (String) session.save(model);
        transaction.commit();
        session.close();
        return uuid;
    }
}
