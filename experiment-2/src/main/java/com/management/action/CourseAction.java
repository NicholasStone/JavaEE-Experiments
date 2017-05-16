package com.management.action;

import com.management.dao.ext.CourseDao;
import com.management.dao.ext.StudentDao;
import com.management.model.CoursesEntity;
import com.management.model.StudentsEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: nicholas
 * @date: 5/13/17
 */
public class CourseAction extends DefaultAction {
    private List        courses;
    private String      id;
    private Set<String> selected;

    private CourseDao courseDao = new CourseDao();

    public String index() throws Exception {
        courses = courseDao.findAll();
        return SUCCESS;
    }

    public String create() {
        return SUCCESS;
    }

    public String select() {
        if (!isPost()) {
            return SUCCESS;
        }
        StudentDao         studentDao      = new StudentDao();
        StudentsEntity     student         = (StudentsEntity) session.get("Auth");
        Set<CoursesEntity> coursesEntities = new HashSet<>();
        if (selected != null) {
            for (String id : selected) {
                coursesEntities.add(courseDao.findById(id));
            }
        }
        student.setCoursesEntities(coursesEntities);
        studentDao.update(student);
        addActionMessage("选课成功");
        return SUCCESS;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public List getCourses() {
        return courses;
    }

    public void setCourses(List courses) {
        this.courses = courses;
    }

    public Set getSelected() {
        return selected;
    }

    public void setSelected(Set<String> selected) {
        this.selected = selected;
    }
}
