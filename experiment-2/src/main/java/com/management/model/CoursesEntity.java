package com.management.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: nicholas
 * @date: 17-5-3
 */
@javax.persistence.Entity
@Table(name = "courses", schema = "message")
public class CoursesEntity implements Entity {
    private String           uuid;
    private String           name;
    private InstructorEntity teacher;


    private Set<StudentsEntity> studentsEntities = new HashSet<>(0);

    public CoursesEntity() {
    }

    public CoursesEntity(String name, InstructorEntity teacher) {
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
    @JoinTable(name = "students_courses", joinColumns = {
            @JoinColumn(name = "StudentsEntity_uuid", nullable = false, updatable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "coursesEntities_uuid", nullable = false, updatable = false)
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
    public InstructorEntity getTeacher() {
        return teacher;
    }

    public void setTeacher(InstructorEntity teacher) {
        this.teacher = teacher;
    }
}