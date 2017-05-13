package com.management.dao.ext;

import com.management.constant.UserIdentity;
import com.management.model.Auth;
import com.management.model.Entity;
import com.management.model.StudentsEntity;
import com.management.model.TeachersEntity;
import com.management.util.Encrypt;

/**
 * Created by nicholas on 5/11/17.
 */
public class AuthDao implements UserIdentity {
    private Auth auth;

    public AuthDao() {
    }

    public AuthDao(Auth auth) {
        this.auth = auth;
    }

    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    public boolean authorize() {
        boolean flag = false;
        if (INSTRUCTOR.equals(auth.getIdentity())) {
            TeachersEntity entity = new TeacherDao().findByName(auth.getUsername());
            if (entity == null) {
                return false;
            }
            if (Encrypt.md5sum(auth.getPassword()).equals(entity.getPassword())) {
                flag = true;
            }
        } else {
            StudentsEntity entity = new StudentDao().findByName(auth.getUsername());
            if (entity == null) {
                return false;
            }
            if (Encrypt.md5sum(auth.getPassword()).equals(entity.getPassword())) {
                flag = true;
            }
        }

        return flag;
    }

    public Entity getEntity() {
        Entity entity;
        if (INSTRUCTOR.equals(auth.getIdentity())) {
            entity = new TeacherDao().findByName(auth.getUsername());
        } else {
            entity = new StudentDao().findByName(auth.getUsername());
        }
        return entity;
    }
}
