package com.twodogs.dao;

import com.twodogs.dao.ext.CourseDao;
import com.twodogs.dao.ext.StudentDao;
import com.twodogs.dao.ext.TeacherDao;
import com.twodogs.model.CoursesEntity;
import com.twodogs.model.StudentsEntity;
import com.twodogs.model.TeachersEntity;
import org.apache.commons.io.output.CountingOutputStream;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nicholas on 5/8/17.
 */
public class DaoTest {
    public static void main(String[] args) {

        StudentDao     student        = new StudentDao();
        StudentsEntity studentsEntity = student.findByName("奥观海");
        System.out.println(studentsEntity.getName() + studentsEntity.getUuid());

        CourseDao     courseDao     = new CourseDao();
        CoursesEntity coursesEntity = courseDao.findByName("Ass we can!");
        System.out.println(coursesEntity.getName() + studentsEntity.getUuid());

        Set<CoursesEntity> set = new HashSet<>();
        set.add(coursesEntity);
        studentsEntity.setCoursesEntities(set);
        student.add(studentsEntity);
    }
}
