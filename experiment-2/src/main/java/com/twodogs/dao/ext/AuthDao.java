package com.twodogs.dao.ext;

import com.twodogs.constant.UserIdentity;
import com.twodogs.model.Auth;
import com.twodogs.model.StudentsEntity;
import com.twodogs.model.TeachersEntity;
import com.twodogs.util.Encrypt;

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
}
