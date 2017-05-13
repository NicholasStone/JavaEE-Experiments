package com.management.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * @author: nicholas
 * @date: 5/13/17
 */
public class CourseAction extends ActionSupport implements SessionAware {
    private Map<String, Object> session;

    public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        session = map;
    }
}
