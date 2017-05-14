package com.management.dao;

import com.management.dao.ext.CourseDao;
import com.management.dao.ext.StudentDao;
import com.management.dao.ext.InstructorDao;
import com.management.model.CoursesEntity;
import com.management.model.InstructorEntity;
import com.management.model.StudentsEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: nicholas
 * @date: 5/8/17
 */
public class DaoTest {
    public static void main(String[] args) {
        InstructorDao    instructorDao    = new InstructorDao();
        InstructorEntity instructorEntity = instructorDao.findByName("teacher1");

        CourseDao     courseDao     = new CourseDao();
        CoursesEntity coursesEntity = new CoursesEntity("Ass We Can", instructorEntity);
        courseDao.save(coursesEntity);
    }
}
