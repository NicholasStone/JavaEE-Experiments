package com.management.dao.ext;

import com.management.dao.Dao;
import com.management.util.Parse;
import com.management.model.CoursesEntity;

import java.util.List;

/**
 * Created by nicholas on 17-5-2.
 */
public class CourseDao extends Dao {

    public List findAll() {
        return super.findAll("FROM CoursesEntity ");
    }

    public CoursesEntity findByName(String name) {
        return (CoursesEntity) super.findByKey("FROM CoursesEntity where name=?", Parse.str2list(name));
    }

    public CoursesEntity findById(String id) {
        return (CoursesEntity) super.findByKey("FROM CoursesEntity where id=?", Parse.str2list(id));
    }
}
