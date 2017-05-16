package com.management.action;

import com.management.model.CoursesEntity;
import com.management.model.StudentsEntity;
import java.util.Set;

/**
 * Created by nicholas on 5/13/17.
 */
public class StudentAction extends DefaultAction {
    private StudentsEntity      student;
    private Set<CoursesEntity>  courses;

    public String index() {
        student = (StudentsEntity) session.get("Auth");
        courses = this.student.getCoursesEntities();
        return SUCCESS;
    }

    public Set<CoursesEntity> getCourses() {
        return courses;
    }

    public void setCourses(Set<CoursesEntity> courses) {
        this.courses = courses;
    }

    public StudentsEntity getStudent() {
        return student;
    }

    public void setStudent(StudentsEntity student) {
        this.student = student;
    }
}
