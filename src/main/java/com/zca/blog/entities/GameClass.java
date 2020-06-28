package com.zca.blog.entities;

import java.util.Date;

public class GameClass {
    private Integer id;

    private String gClassName;

    private Date creatorTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getgClassName() {
        return gClassName;
    }

    public void setgClassName(String gClassName) {
        this.gClassName = gClassName;
    }

    public Date getCreatorTime() {
        return creatorTime;
    }

    public void setCreatorTime(Date creatorTime) {
        this.creatorTime = creatorTime;
    }
}