package com.twodogs.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by nicholas on 17-4-26.
 */
@Entity
@Table(name = "students", schema = "message")
public class StudentsEntity {
    private String uuid;
    private String name;

    @Id
    @Column(name = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentsEntity that = (StudentsEntity) o;

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
