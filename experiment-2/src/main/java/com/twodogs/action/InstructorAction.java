package com.twodogs.action;

import com.opensymphony.xwork2.ActionSupport;
import com.twodogs.dao.Dao;
import com.twodogs.dao.ext.TeacherDao;
import com.twodogs.model.Entity;

/**
 * Created by nicholas on 5/12/17.
 */
public class InstructorAction extends ActionSupport {
    private String name;
    private Entity entity;

    public String newCourse() {
        return SUCCESS;
    }

    public String index(){
        return SUCCESS;
    }
}
