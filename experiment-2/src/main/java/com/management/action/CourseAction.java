package com.management.action;

import com.management.dao.ext.CourseDao;
import com.management.model.CoursesEntity;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * @author: nicholas
 * @date: 5/13/17
 */
public class CourseAction extends ActionSupport implements SessionAware {
    private CoursesEntity       coursesEntity;
    private Map<String, Object> session;
    private String              id;

    public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        session = map;
    }

    public String index() throws Exception {
        coursesEntity = new CourseDao().findById(id);
        return coursesEntity == null ? ERROR : SUCCESS;
    }

    public String create(){
        return SUCCESS;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public CoursesEntity getCoursesEntity() {
        return coursesEntity;
    }

    public void setCoursesEntity(CoursesEntity coursesEntity) {
        this.coursesEntity = coursesEntity;
    }
}
