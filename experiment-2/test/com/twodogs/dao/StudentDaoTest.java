package com.twodogs.dao;

import com.twodogs.dao.ext.StudentDao;
import com.twodogs.model.StudentsEntity;

/**
 * Created by nicholas on 5/8/17.
 */
public class StudentDaoTest {
    public static void main(String[] args){
        Dao student = new StudentDao();
        StudentsEntity studentsEntity = new StudentsEntity();
        studentsEntity.setName("13");
        student.add(studentsEntity);
    }
}
