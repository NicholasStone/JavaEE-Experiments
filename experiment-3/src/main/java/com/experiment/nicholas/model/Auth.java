package com.experiment.nicholas.model;

import java.io.Serializable;

/**
 * @Author: nicholas
 * @Date: 5/17/17
 */

public class Auth implements Serializable {
    private static final long serialVersionUID = 1L;

    private int    id;
    private String username;
    private String password;

    public Auth(){}

    public Auth(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
