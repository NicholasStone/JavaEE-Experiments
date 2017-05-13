package com.management.dao;

import com.management.dao.ext.CourseDao;
import com.management.dao.ext.StudentDao;
import com.management.dao.ext.TeacherDao;
import com.management.model.CoursesEntity;
import com.management.model.StudentsEntity;
import com.management.model.TeachersEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nicholas on 5/8/17.
 */
public class DaoTest {
    public static void main(String[] args) {
//        save();
        TeacherDao teacherDao = new TeacherDao();
        TeachersEntity teachersEntity = teacherDao.findByName("teacher1");
        Set<CoursesEntity> coursesEntitySet = teachersEntity.getCoursesEntities();
        for(CoursesEntity entity:coursesEntitySet){
            System.out.println(entity.getUuid());
            System.out.println(entity.getName());
        }
    }

    private static void save() {
        TeacherDao     teacher        = new TeacherDao();
        TeachersEntity teachersEntity = teacher.findByName("teacher1");
        teachersEntity.setPassword("123456");
        System.out.println(teachersEntity.getUuid());


        StudentDao     student        = new StudentDao();
        StudentsEntity studentsEntity = student.findByName("student1");
        studentsEntity.setPassword("123456");
        System.out.println(studentsEntity.getUuid());

        CourseDao courseDao = new CourseDao();
//        CoursesEntity coursesEntity = courseDao.findByName("Ass we can!");
        CoursesEntity coursesEntity = new CoursesEntity("Ass we can!!", teachersEntity);
        System.out.println(coursesEntity.getUuid());

        Set<CoursesEntity> set = new HashSet<>();
        set.add(coursesEntity);
        studentsEntity.setCoursesEntities(set);
        student.update(studentsEntity);
    }
}
