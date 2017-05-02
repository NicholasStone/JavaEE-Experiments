package com.messageboard.exception;

/**
 * Created by nicholas on 17-4-24.
 */
public class KeyEmptyException extends Exception {
    private String key;

    public KeyEmptyException(String s, String key) {
        super(s);
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "不能为空";
    }
}
