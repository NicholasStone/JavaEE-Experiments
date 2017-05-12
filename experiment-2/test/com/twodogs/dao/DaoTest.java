package com.twodogs.dao;

import com.twodogs.dao.ext.CourseDao;
import com.twodogs.dao.ext.StudentDao;
import com.twodogs.dao.ext.TeacherDao;
import com.twodogs.model.CoursesEntity;
import com.twodogs.model.StudentsEntity;
import com.twodogs.model.TeachersEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nicholas on 5/8/17.
 */
public class DaoTest {
    public static void main(String[] args) {
//        save();
        TeachersEntity teachersEntity = new TeachersEntity();
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
