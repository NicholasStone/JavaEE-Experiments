package com.management.interceptor;

import com.management.constant.UserIdentity;
import com.management.model.Auth;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author: nicholas
 * @date: 5/14/17
 */
public class CourseInterceptor extends AbstractInterceptor implements UserIdentity {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        String action = actionInvocation.getProxy().getActionName();
        Auth auth = (Auth) actionInvocation.getInvocationContext().getSession().get("Auth");
        System.out.println("CourseInterceptor:" + action);
        if (action.equals("store")) {
            if (auth.getIdentity().equals(INSTRUCTOR)) {
                return actionInvocation.invoke();
            } else {
                return "permission-denied";
            }
        }
        if (action.equals("select")) {
            if (auth.getIdentity().equals(STUDENT)) {
                return actionInvocation.invoke();
            } else {
                return "permission-denied";
            }
        }
        return actionInvocation.invoke();
    }
}
