package com.twodogs.dao.impl;

import com.twodogs.dao.TeacherDao;
import com.twodogs.model.TeachersEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by nicholas on 17-5-3.
 */
public class TeacherDaoImpl implements TeacherDao {
    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    @Override
    public List findAll() {
        Session     session     = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List        list        = session.createQuery("FROM TeachersEntity ").list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public String addTeacher(TeachersEntity teacher) {
        Session     session     = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String      uuid        = (String) session.save(teacher);
        transaction.commit();
        session.close();
        return uuid;
    }
}
