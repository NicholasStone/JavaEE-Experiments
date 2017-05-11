package com.twodogs.action;

import com.opensymphony.xwork2.ActionSupport;
import com.twodogs.dao.ext.AuthDao;
import com.twodogs.model.Auth;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by nicholas on 17-5-2.
 */
public class AuthAction extends ActionSupport implements ServletRequestAware {
    private String password;
    private String username;
    private String identity;
    private Auth   auth;
    HttpServletRequest request;

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

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    @Override
    public void validate() {
        if (!request.getMethod().toUpperCase().equals("POST")) {
            return;
        }
        auth = new Auth(username, password, identity);
        if (auth.getUsername() == null || auth.getUsername().trim().equals("")) {
            addFieldError("username", "用户名不能为空");
        }
        if (auth.getPassword() == null || auth.getPassword().trim().equals("")) {
            addFieldError("password", "密码不能为空");
        }
        if (auth.getIdentity() == null) {
            addFieldError("identity", "请选择身份");
        }
        if (!new AuthDao(auth).authorize()) {
            addFieldError("username", "用户名不存在或密码错误");
        }
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }
}
