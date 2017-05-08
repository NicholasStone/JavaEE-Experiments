package com.twodogs.dao.ext;

import com.twodogs.dao.Dao;

import java.util.List;

/**
 * Created by nicholas on 17-5-3.
 */
public class TeacherDao extends Dao {

    public List findAll() {
        return super.findAll("FROM TeachersEntity ");
    }
}
