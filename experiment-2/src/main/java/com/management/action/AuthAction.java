package com.management.action;

import com.management.dao.ext.StudentDao;
import com.management.dao.ext.InstructorDao;
import com.management.util.Encrypt;
import com.opensymphony.xwork2.ActionSupport;
import com.management.constant.UserIdentity;
import com.management.model.Auth;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author: nicholas
 * @date: 17-5-2
 */
public class AuthAction extends ActionSupport implements ServletRequestAware, SessionAware, UserIdentity {
    private String              password;
    private String              username;
    private String              identity;
    private Auth                auth;
    private Map<String, Object> session;
    private HttpServletRequest  request;

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

    public String signIn() throws Exception {
        if (!request.getMethod().toUpperCase().equals("POST")) {
            System.out.println("login");
            return LOGIN;
        }
        session.put("Auth", auth);
        return identity;
    }

    public String signOut() {
        session.remove("Auth");
        return SUCCESS;
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
        }
        if (password == null || password.trim().equals("")) {
            addActionError("密码不能为空");
            return;
        }
        if (!(identity.equals(STUDENT) || identity.equals(INSTRUCTOR))) {
            addActionError("输入不合法");
            return;
        }
        if (!authCheck()) {
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

    private boolean authCheck() {
        if (INSTRUCTOR.equals(identity)) {
            auth = new InstructorDao().findByName(username);
        } else {
            auth = new StudentDao().findByName(username);
        }
        return auth != null && Encrypt.md5sum(password).equals(auth.getPassword());
    }
}
