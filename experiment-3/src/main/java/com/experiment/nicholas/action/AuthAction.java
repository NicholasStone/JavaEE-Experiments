package com.experiment.nicholas.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: nicholas
 * @Date: 5/17/17
 */
public class AuthAction extends ActionSupport implements ServletRequestAware {
    private String             username;
    private String             password;
    private HttpServletRequest request;

    @Override
    public String execute() throws Exception {
        return super.execute();
    }

    @Override
    public void validate() {
        if (isPost()){
            if (username == null || username.trim().equals("")){
            }
        }
    }

    private boolean isPost(){
        return request.getMethod().toUpperCase().equals("POST");
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

    public void setServletRequest(javax.servlet.http.HttpServletRequest httpServletRequest) {
        request = httpServletRequest;
    }
}

