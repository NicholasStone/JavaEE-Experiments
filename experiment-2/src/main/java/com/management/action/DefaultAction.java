package com.management.action;

import com.management.constant.UserIdentity;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by nicholas on 5/16/17.
 */
abstract public class DefaultAction extends ActionSupport implements SessionAware, ServletRequestAware, UserIdentity {
    protected Map<String, Object> session;
    protected HttpServletRequest  request;

    public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    public ServletRequest getRequest() {
        return request;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }

    public boolean isPost() {
        return request.getMethod().toUpperCase().equals("POST");
    }
}
