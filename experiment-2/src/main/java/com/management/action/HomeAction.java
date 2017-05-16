package com.management.action;

import com.management.model.Auth;
/**
 * @author: nicholas
 * @date: 5/16/17
 */
public class HomeAction extends DefaultAction {
    @Override
    public String execute() throws Exception {
        return ((Auth) session.get("Auth")).getIdentity();
    }
}
