package com.twodogs.dao;

import com.twodogs.model.TeachersEntity;

import java.util.List;
import java.util.Set;

/**
 * Created by nicholas on 17-5-3.
 */
public interface TeacherDao {
    public List findAll();
    public String addTeacher(TeachersEntity teachersEntity);
}
