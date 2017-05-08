package com.twodogs.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by nicholas on 17-5-3.
 */
@Entity
@Table(name = "courses", schema = "message")
public class CoursesEntity implements Model{
    private String         uuid;
    private String         name;
    private TeachersEntity teacher;


    private Set<StudentsEntity> studentsEntities = new HashSet<>(0);

    public CoursesEntity() {
    }

    public CoursesEntity(String name, TeachersEntity teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    @Id
    @Column(name = "uuid")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "student_course_pivot", joinColumns = {
            @JoinColumn(name = "course_id", nullable = false, updatable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "student_id", nullable = false, updatable = false)
    })
    //https://www.mkyong.com/hibernate/hibernate-many-to-many-relationship-example-annotation/
    public Set<StudentsEntity> getStudentsEntities() {
        return studentsEntities;
    }

    public void setStudentsEntities(Set<StudentsEntity> studentsEntities) {
        this.studentsEntities = studentsEntities;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", nullable = false)
    //https://www.mkyong.com/hibernate/hibernate-one-to-many-relationship-example-annotation/
    public TeachersEntity getTeacher() {
        return teacher;
    }

    public void setTeacher(TeachersEntity teacher) {
        this.teacher = teacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoursesEntity that = (CoursesEntity) o;

        if (uuid != null ? !uuid.equals(that.uuid) : that.uuid != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (teacher != null ? !teacher.equals(that.teacher) : that.teacher != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uuid != null ? uuid.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
        return result;
    }
}
