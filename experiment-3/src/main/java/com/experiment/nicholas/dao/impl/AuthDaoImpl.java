package com.experiment.nicholas.dao.impl;

import com.experiment.nicholas.dao.AuthDao;
import com.experiment.nicholas.model.Auth;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.transaction.Transaction;

/**
 * @Author: nicholas
 * @Date: 5/17/17
 */
public class AuthDaoImpl implements AuthDao{

    private SessionFactory sessionFactory;

    public Auth authorize(String username, String password) {
        return null;
    }

    public Auth findByName(String name){
        sessionFactory.openSession().beginTransaction();
        return null;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
