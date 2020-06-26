package com.zca.blog.entities;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;

    private String userName;

    private String password;

    private String email;

    private String phone;

    private Date creatorTime;

    private Date updateTime;

    private String photo;

    private String comment;

    private Integer status;

    private Integer worksNum;
}