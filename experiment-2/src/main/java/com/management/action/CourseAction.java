package com.management.action;

import com.management.dao.ext.CourseDao;
import com.management.dao.ext.StudentDao;
import com.management.model.CoursesEntity;
import com.management.model.InstructorEntity;
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
    private String      name;

    private CourseDao courseDao = new CourseDao();

    public String index() throws Exception {
        courses = courseDao.findAll();
        return SUCCESS;
    }

    public String store() {
        if (isPost()) {
            InstructorEntity instructor    = (InstructorEntity) session.get("Auth");
            CourseDao        dao           = new CourseDao();
            CoursesEntity    coursesEntity = dao.findByName(name);

            if (coursesEntity == null) {
                coursesEntity = new CoursesEntity(name, instructor);
                System.out.println(coursesEntity);
                dao.save(coursesEntity);
                return SUCCESS;
            } else {
                addActionError("课程名称重复");
                return INPUT;
            }
        } else {
            return INPUT;
        }
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

    public String show() throws Exception {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
