package com.twodogs.dao.ext;

import com.twodogs.model.Auth;
import com.twodogs.model.StudentsEntity;
import com.twodogs.model.TeachersEntity;
import com.twodogs.util.Encrypt;

/**
 * Created by nicholas on 5/11/17.
 */
public class AuthDao {
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
        if ("teacher".equals(auth.getIdentity())) {
            TeachersEntity entity = new TeacherDao().findByName(auth.getUsername());
            if (Encrypt.md5(auth.getPassword()).equals(entity.getPassword())) {
                flag = true;
            }
        } else {
            StudentsEntity entity = new StudentDao().findByName(auth.getUsername());
            if (Encrypt.md5(auth.getPassword()).equals(entity.getPassword())) {
                flag = true;
            }
        }

        return flag;
    }
}
