package com.twodogs.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Created by nicholas on 5/10/17.
 */
public class AuthInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        String action = actionInvocation.getProxy().getActionName();
        if ("auth".equals(action)) {
            return actionInvocation.invoke();
        }

        String user = (String) actionInvocation.getInvocationContext().getSession().get("username");
        if (user == null) {
            return "auth";
        }
        return actionInvocation.invoke();
    }
}
