package com.experiment.nicholas.action;

import com.experiment.nicholas.dao.AuthDao;
import com.experiment.nicholas.dao.impl.AuthDaoImpl;
import com.experiment.nicholas.model.Auth;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author: nicholas
 * @Date: 5/17/17
 */
public class AuthAction extends ActionSupport implements ServletRequestAware, SessionAware {
    private String              username;
    private String              password;
    private HttpServletRequest  request;
    private AuthDao             dao;
    private Map<String, Object> session;

    @Override
    public String execute() throws Exception {
        Auth auth = dao.authorize(new Auth(username, password));
        if (auth == null) {
            addFieldError("username", "用户不存在或密码错误");
            return INPUT;
        } else {
            session.put("Auth", auth);
            return SUCCESS;
        }
    }

    @Override
    public void validate() {
        if (isPost()) {
            if (username == null || username.trim().equals("")) {
                addFieldError("username", "用户名不能为空");
            }
            if (password == null || username.trim().equals("")) {
                addFieldError("password", "密码不能为空");
            }
        }
    }

    private boolean isPost() {
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

    public void setDao(AuthDao dao) {
        this.dao = dao;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        session = map;
    }
}

