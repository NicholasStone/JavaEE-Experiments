package com.management.action;

import com.management.dao.ext.InstructorDao;
import com.management.model.InstructorEntity;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author: nicholas
 * @date: 5/12/17
 */
public class InstructorAction extends ActionSupport {
    private String           name;
    private InstructorEntity teacher;

    public String newCourse() {
        return SUCCESS;
    }

    public String index(){
        InstructorDao teacherDao = new InstructorDao();
        teacher = teacherDao.findById("");
        return SUCCESS;
    }
}
