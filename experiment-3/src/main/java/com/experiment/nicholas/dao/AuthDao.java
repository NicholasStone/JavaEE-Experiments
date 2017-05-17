package com.experiment.nicholas.dao;

import com.experiment.nicholas.model.Auth;

/**
 * @Author: nicholas
 * @Date: 5/17/17
 */
public interface AuthDao {
    public Auth authorize(String username, String password);

    public Auth findByName(String name);
}
