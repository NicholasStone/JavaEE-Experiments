package com.twodogs.dao.ext;

import com.twodogs.dao.Dao;
import com.twodogs.util.Parse;
import com.twodogs.model.CoursesEntity;

import java.util.List;

/**
 * Created by nicholas on 17-5-2.
 */
public class CourseDao extends Dao {

    public List findAll() {
        return super.findAll("FROM CoursesEntity ");
    }

    public CoursesEntity findByName(String name) {
        return (CoursesEntity) super.findByKey("from CoursesEntity where name=?", Parse.str2list(name));
    }
}
