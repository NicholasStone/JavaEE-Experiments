package com.twodogs.dao.ext;

import com.twodogs.dao.Dao;
import com.twodogs.model.TeachersEntity;
import com.twodogs.util.Parse;

import java.util.List;

/**
 * Created by nicholas on 17-5-3.
 */
public class TeacherDao extends Dao {

    public List findAll() {
        return super.findAll("FROM TeachersEntity ");
    }

    public TeachersEntity findByName(String name) {
        return (TeachersEntity) super.findByKey("FROM TeachersEntity where name=?", Parse.str2list(name));
    }
}
