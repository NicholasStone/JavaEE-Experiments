package com.management.action;

import com.management.model.InstructorEntity;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * @author: nicholas
 * @date: 5/12/17
 */
public class InstructorAction extends DefaultAction {
    private String              name;
    private InstructorEntity    instructor;

    public String index() {
        instructor = (InstructorEntity) session.get("Auth");
        return SUCCESS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InstructorEntity getInstructor() {
        return instructor;
    }

    public void setInstructor(InstructorEntity instructor) {
        this.instructor = instructor;
    }
}
