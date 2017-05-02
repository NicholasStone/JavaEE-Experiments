package com.twodogs.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by nicholas on 17-4-26.
 */
@Entity
@Table(name = "courses", schema = "message")
public class CoursesEntity {
    private String uuid;
    private String name;

    public CoursesEntity() {
    }

    public CoursesEntity(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "uuid", columnDefinition = "uuid", updatable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy = "uuid2")
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String  uuid) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoursesEntity that = (CoursesEntity) o;

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
