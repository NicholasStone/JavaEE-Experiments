package com.twodogs.dao.ext;

import com.twodogs.dao.Dao;

import java.util.List;

/**
 * Created by nicholas on 17-5-2.
 */
public class CourseDao extends Dao {

    public List findAll() {
        return super.findAll("FROM CoursesEntity ");
    }
}
