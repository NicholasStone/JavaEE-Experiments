package com.messageboard.dean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by nicholas on 17-4-20.
 */
public class Message {
    private int    id;
    private String title;
    private String message;
    //the publisher name
    private String from;
    //publish time
    private String time;

    public Message() {
        setTime(new Date());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setTime(Date date) {
        SimpleDateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.time = dateFormate.format(date);
    }
}
