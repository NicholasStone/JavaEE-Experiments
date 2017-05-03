package com.twodogs.dao.impl;

import com.twodogs.dao.CourseDao;
import com.twodogs.model.CoursesEntity;
import com.twodogs.model.Model;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.UUID;

/**
 * Created by nicholas on 17-5-2.
 */
public class CourseDaoImpl implements CourseDao {
    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public List findAll() {
        Session     session     = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List        list        = session.createQuery("FROM CoursesEntity ").list();
        transaction.commit();
        session.close();
        return list;
    }

    public String add(Model course) {
        Session     session     = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String      uuid        = (String) session.save(course);
        transaction.commit();
        session.close();
        return uuid;
    }
}
