package com.management.dao.ext;

import com.management.dao.Dao;
import com.management.model.TeachersEntity;
import com.management.util.Parse;

import java.util.List;

/**
 * Created by nicholas on 17-5-3.
 */
public class TeacherDao extends Dao {

    public List findAll() {
        return super.findAll("FROM TeachersEntity ");
    }

    public TeachersEntity findById(String id) {
        return (TeachersEntity) super.findByKey("FROM TeacherEntity where id=?", Parse.str2list(id));
    }

    public TeachersEntity findByName(String name) {
        return (TeachersEntity) super.findByKey("FROM TeachersEntity where name=?", Parse.str2list(name));
    }

}
