package com.management.model;

/**
 * @author: nicholas
 * @date: 5/11/17
 */
public abstract class Auth {
    protected String uuid;
    protected String name;
    protected String password;
    protected String identity;

    public Auth() {
    }

    public Auth(String name, String password, String identity) {
        this.name = name;
        this.password = password;
        this.identity = identity;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @Override
    public String toString() {
        return "name:" + name +
                "password:" + password +
                "identity:" + identity;
    }
}
