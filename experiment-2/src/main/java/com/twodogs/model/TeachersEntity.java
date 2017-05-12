package com.twodogs.model;

import com.twodogs.util.Encrypt;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by nicholas on 17-5-3.
 */
@Entity
@Table(name = "teachers", schema = "message")
public class TeachersEntity implements Model {
    private String uuid;
    private String name;
    private String password;
    private Set<CoursesEntity> coursesEntities = new HashSet<>(0);

    public TeachersEntity(String name) {
        this.name = name;
    }

    public TeachersEntity() {
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
        this.password = Encrypt.md5sum(password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeachersEntity that = (TeachersEntity) o;

        if (uuid != null ? !uuid.equals(that.uuid) : that.uuid != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uuid != null ? uuid.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
