package com.twodogs.dao.ext;

import com.twodogs.dao.Dao;

import java.util.List;

/**
 * Created by nicholas on 5/8/17.
 */
public class StudentDao extends Dao {
    public List findAll() {
        return super.findAll("FROM StudentEntity");
    }
}
