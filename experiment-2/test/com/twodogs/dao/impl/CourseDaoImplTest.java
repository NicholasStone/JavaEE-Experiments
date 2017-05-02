package com.twodogs.dao.impl;

import com.twodogs.dao.CourseDao;
import com.twodogs.model.CoursesEntity;

import java.util.List;


/**
 * Created by nicholas on 17-5-2.
 */
class CourseDaoImplTest {
    private CourseDao courseDao = new CourseDaoImpl();

    public void addCourse(){
        CoursesEntity course = new CoursesEntity("编译原理");
        System.out.println(this.courseDao.addCourse(course));
    }

    public void findAll(){
        List courses = courseDao.findAll();
        for (Object course1 : courses) {
            CoursesEntity course = (CoursesEntity) course1;
            System.out.println(course.getUuid());
            System.out.println(course.getName());
        }
    }

    public static void main(String[] args) {
        CourseDaoImplTest test = new CourseDaoImplTest();
        test.addCourse();
        test.findAll();
    }

}