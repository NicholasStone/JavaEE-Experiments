package com.twodogs.action;

import com.opensymphony.xwork2.ActionSupport;
import com.twodogs.constant.UserIdentity;
import com.twodogs.dao.ext.AuthDao;
import com.twodogs.model.Auth;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by nicholas on 17-5-2.
 */
public class AuthAction extends ActionSupport implements ServletRequestAware, SessionAware, UserIdentity {
    private String              password;
    private String              username;
    private String              identity;
    private Auth                auth;
    private Map<String, Object> session;

    HttpServletRequest request;

    public String getDefaultIdentityValue() {
        return STUDENT;
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

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @Override
    public String execute() throws Exception {
        if (!request.getMethod().toUpperCase().equals("POST")) {
            return LOGIN;
        }
        session.put("Auth", auth);
        return identity;
    }

    @Override
    public void validate() {
        if (!request.getMethod().toUpperCase().equals("POST")) {
            return;
        }
        if (identity == null) {
            addActionError("请选择身份");
            return;
        }
        if (username == null || username.trim().equals("")) {
            addActionError("用户名不能为空");
//            return;
        }
        if (password == null || password.trim().equals("")) {
            addActionError("密码不能为空");
            return;
        }
        if (!(identity.equals(STUDENT) || identity.equals(INSTRUCTOR))) {
            addActionError("输入不合法");
            return;
        }
        auth = new Auth(username, password, identity);
        if (new AuthDao(auth).authorize()) {
            addActionError("用户不存在或密码错误");
        }
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
