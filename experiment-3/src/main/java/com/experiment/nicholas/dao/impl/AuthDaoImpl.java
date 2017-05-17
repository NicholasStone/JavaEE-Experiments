package com.experiment.nicholas.dao.impl;

import com.experiment.nicholas.dao.AuthDao;
import com.experiment.nicholas.model.Auth;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
/**
 * @Author: nicholas
 * @Date: 5/17/17
 */
public class AuthDaoImpl extends HibernateDaoSupport implements AuthDao {

    public Auth authorize(Auth auth) {
        Auth recode = findByName(auth.getUsername());
        return auth.getPassword().equals(recode.getPassword()) ? recode : null;
    }

    public Auth findByName(String name) {
        return (Auth) getHibernateTemplate().find("FROM Auth where username=?", name).get(0);

    }

    public void setFactory(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }
}
