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
//        save();
        InstructorDao      teacherDao       = new InstructorDao();
        InstructorEntity   instructorEntity = teacherDao.findByName("teacher1");
        Set<CoursesEntity> coursesEntitySet = instructorEntity.getCoursesEntities();
        for(CoursesEntity entity:coursesEntitySet){
            System.out.println(entity.getUuid());
            System.out.println(entity.getName());
        }
    }

    private static void save() {
        InstructorDao    teacher          = new InstructorDao();
        InstructorEntity instructorEntity = teacher.findByName("teacher1");
        instructorEntity.setPassword("123456");
        System.out.println(instructorEntity.getUuid());


        StudentDao     student        = new StudentDao();
        StudentsEntity studentsEntity = student.findByName("student1");
        studentsEntity.setPassword("123456");
        System.out.println(studentsEntity.getUuid());

        CourseDao courseDao = new CourseDao();
//        CoursesEntity coursesEntity = courseDao.findByName("Ass we can!");
        CoursesEntity coursesEntity = new CoursesEntity("Ass we can!!", instructorEntity);
        System.out.println(coursesEntity.getUuid());

        Set<CoursesEntity> set = new HashSet<>();
        set.add(coursesEntity);
        studentsEntity.setCoursesEntities(set);
        student.update(studentsEntity);
    }
}
