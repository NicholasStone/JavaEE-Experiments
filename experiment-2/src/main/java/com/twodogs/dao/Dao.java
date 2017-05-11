package com.twodogs.dao;

import com.twodogs.model.Model;
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

    protected Model findByKey(String queryString, List<String> params) {
        Session     session     = this.getSession();
        Transaction transaction = session.beginTransaction();
        Query       query       = session.createQuery(queryString);
        query.setMaxResults(1);
        int index = 0;
        for (String param : params) {
            query.setParameter(index++, param);
        }
        Model model = (Model) query.uniqueResult();
        transaction.commit();
//        session.close();
        return model;
    }

    public String add(Model model) {
        Session     session     = this.getSession();
        Transaction transaction = session.beginTransaction();
        String      uuid        = (String) session.save(model);
        transaction.commit();
//        session.close();
        return uuid;
    }

    public void update(Model model) {
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
