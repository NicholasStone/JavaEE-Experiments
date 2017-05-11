package com.twodogs.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by nicholas on 5/10/17.
 */
public class IndexAction extends ActionSupport {
    public String index() {
        System.out.println("index");
        return SUCCESS;
    }
}
