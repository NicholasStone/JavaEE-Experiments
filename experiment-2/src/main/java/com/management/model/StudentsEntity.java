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
@Table(name = "students", schema = "message")
public class StudentsEntity extends Auth implements Entity {
    private String uuid;
    private Set<CoursesEntity> coursesEntities = new HashSet<>(0);

    public StudentsEntity() {
    }

    public StudentsEntity(String name) {
        this.name = name;
    }

    public StudentsEntity(String name, String password, String identity) {
        super(name, password, identity);
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentsEntity that = (StudentsEntity) o;

        return (uuid != null ? uuid.equals(that.uuid) : that.uuid == null) && (name != null ? name.equals(that.name) : that.name == null);
    }

    @Override
    public int hashCode() {
        int result = uuid != null ? uuid.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
