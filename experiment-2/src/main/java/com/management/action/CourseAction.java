package com.management.action;

import com.management.dao.ext.CourseDao;
import com.management.model.CoursesEntity;
import com.management.model.InstructorEntity;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author: nicholas
 * @date: 5/13/17
 */
public class CourseAction extends ActionSupport implements SessionAware, ServletRequestAware {
    private String              id;
    private String              name;
    private CoursesEntity       coursesEntity;
    private Map<String, Object> session;
    private HttpServletRequest  request;

    public String index() throws Exception {
        coursesEntity = new CourseDao().findById(id);
        return coursesEntity == null ? ERROR : SUCCESS;
    }

    public String store() {
        if (request.getMethod().equals("POST")) {
            InstructorEntity instructor = (InstructorEntity) session.get("Auth");
            CourseDao        dao        = new CourseDao();
            coursesEntity = dao.findByName(name);
            System.out.println(coursesEntity);
            if (coursesEntity == null) {
                coursesEntity = new CoursesEntity(name, instructor);
                System.out.println(coursesEntity);
                dao.save(coursesEntity);
                return SUCCESS;
            }else {
                addActionError("课程名称重复");
                return INPUT;
            }
        } else {
            return INPUT;
        }
    }

    public String select() {
        return SUCCESS;
    }

    public String show() throws Exception {
        return "success";
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

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        session = map;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
