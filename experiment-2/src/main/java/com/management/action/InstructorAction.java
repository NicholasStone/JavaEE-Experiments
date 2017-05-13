package com.management.action;

import com.management.dao.ext.TeacherDao;
import com.management.model.TeachersEntity;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by nicholas on 5/12/17.
 */
public class InstructorAction extends ActionSupport {
    private String         name;
    private TeachersEntity teacher;

    public String newCourse() {
        return SUCCESS;
    }

    public String index(){
        TeacherDao teacherDao = new TeacherDao();
        teacher = teacherDao.findById("");
        return SUCCESS;
    }
}
