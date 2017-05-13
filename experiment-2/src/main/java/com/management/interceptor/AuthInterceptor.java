package com.management.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.management.model.Auth;

/**
 * @author: nicholas
 * @date: 5/10/17
 */
public class AuthInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        String action = actionInvocation.getProxy().getActionName();
        if ("signIn".equals(action)) {
            return actionInvocation.invoke();
        }

        Auth auth = (Auth) actionInvocation.getInvocationContext().getSession().get("Auth");
        if (auth == null) {
            return "login";
        }
        return actionInvocation.invoke();
    }
}
