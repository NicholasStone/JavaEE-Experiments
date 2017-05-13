package com.management.model;

import com.management.util.Encrypt;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: nicholas
 * @date: 17-5-3
 */
@javax.persistence.Entity
@Table(name = "instructor", schema = "message")
public class InstructorEntity extends Auth implements Entity {
    private Set<CoursesEntity> coursesEntities = new HashSet<>(0);

    public InstructorEntity(String name) {
        this.name = name;
    }

    public InstructorEntity() {
    }

    public InstructorEntity(String name, String password, String identity) {
        super(name, password, identity);
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "teacher")
    public Set<CoursesEntity> getCoursesEntities() {
        return coursesEntities;
    }

    public void setCoursesEntities(Set<CoursesEntity> coursesEntities) {
        this.coursesEntities = coursesEntities;
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

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
