package com.twodogs.dao;

import com.twodogs.model.CoursesEntity;

import java.util.List;
import java.util.UUID;

/**
 * Created by nicholas on 17-5-2.
 */
public interface CourseDao {
    public List findAll();
    public String addCourse(CoursesEntity course);
}
