package com.management.dao.ext;

import com.management.dao.Dao;
import com.management.util.Parse;
import com.management.model.StudentsEntity;

import java.util.List;

/**
 * Created by nicholas on 5/8/17.
 */
public class StudentDao extends Dao {
    public List findAll() {
        return super.findAll("FROM StudentEntity");
    }

    public StudentsEntity findByName(String name) {
        return (StudentsEntity) super.findByKey("from StudentsEntity where name=?", Parse.str2list(name));
    }

    public StudentsEntity findById(String uuid) {
        return (StudentsEntity)super.findByKey("from StudentEntity where id=?", Parse.str2list(uuid));
    }
}
