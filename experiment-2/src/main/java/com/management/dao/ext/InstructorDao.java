package com.management.dao.ext;

import com.management.dao.Dao;
import com.management.model.InstructorEntity;
import com.management.util.Parse;

import java.util.List;

/**
 * @author: nicholas
 * @date: 17-5-3
 */
public class InstructorDao extends Dao {

    public List findAll() {
        return super.findAll("FROM InstructorEntity ");
    }

    public InstructorEntity findById(String id) {
        return (InstructorEntity) super.findByKey("FROM InstructorEntity where id=?", Parse.str2list(id));
    }

    public InstructorEntity findByName(String name) {
        return (InstructorEntity) super.findByKey("FROM InstructorEntity where name=?", Parse.str2list(name));
    }

}
