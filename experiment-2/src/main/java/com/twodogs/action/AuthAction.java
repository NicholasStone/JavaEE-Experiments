package com.twodogs.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.xml.ws.Action;
import java.util.List;

/**
 * Created by nicholas on 17-5-2.
 */
public class AuthAction extends ActionSupport {
    private String  password;
    private String  username;
    private boolean identity;

    public boolean isIdentity() {
        return identity;
    }

    public void setIdentity(boolean identity) {
        this.identity = identity;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String auth() throws Exception {
        System.out.println(username);
        System.out.println(password);
        System.out.println(identity);
        return SUCCESS;
    }
}
