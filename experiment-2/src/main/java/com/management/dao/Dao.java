package com.management.dao;

import com.management.model.Entity;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by nicholas on 5/3/17.
 */
public abstract class Dao {
    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    protected List findAll(String query) {
        Session     session     = this.getSession();
        Transaction transaction = session.beginTransaction();
        List        list        = session.createQuery(query).list();
        transaction.commit();
//        session.close();
        return list;
    }

    protected Entity findByKey(String queryString, List<String> params) {
        Session     session     = this.getSession();
        Transaction transaction = session.beginTransaction();
        Query       query       = session.createQuery(queryString);
        query.setMaxResults(1);
        int index = 0;
        for (String param : params) {
            query.setParameter(index++, param);
        }
        Entity model = (Entity) query.uniqueResult();
        transaction.commit();
//        session.close();
        return model;
    }

    public String save(Entity model) {
        Session     session     = this.getSession();
        Transaction transaction = session.beginTransaction();
        String      uuid        = (String) session.save(model);
        transaction.commit();
//        session.close();
        return uuid;
    }

    public void update(Entity model) {
        Session     session     = this.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(model);
        transaction.commit();
//        session.close();
    }

    private Session getSession() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        }catch (HibernateException e){
            session = sessionFactory.openSession();
        }
        return session;
    }
}