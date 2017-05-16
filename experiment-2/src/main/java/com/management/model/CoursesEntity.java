package com.management.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: nicholas
 * @date: 17-5-3
 */
@javax.persistence.Entity
@Table(name = "courses", schema = "message")
public class CoursesEntity implements Entity {
    private String              uuid;
    private String              name;
    private InstructorEntity    instructor;
    private Map<String, String> timeAndLocation;
    @Transient
    private Set<StudentsEntity> studentsEntities = new HashSet<>(0);

    {
        timeAndLocation = new HashMap<>();
        timeAndLocation.put("第1-18周周一第1-2节","教学主楼A303");
        timeAndLocation.put("第1-18周周三第5-6节","教学主楼A502");
        timeAndLocation.put("第1-18周周四第3-4节","教学主楼A207");
    }

    public CoursesEntity() {
    }

    public CoursesEntity(String name, InstructorEntity instructor) {
        this.name = name;
        this.instructor = instructor;
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
    public InstructorEntity getInstructor() {
        return instructor;
    }

    public void setInstructor(InstructorEntity teacher) {
        this.instructor = teacher;
    }

    @Transient
    public Map<String, String> getTimeAndLocation() {
        return timeAndLocation;
    }
}
