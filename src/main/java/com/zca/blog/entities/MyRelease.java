package com.zca.blog.entities;

import lombok.Data;

import java.util.Date;

@Data
public class MyRelease {
    private Integer id;

    private Date creatorTime;

    private Date updateTime;

    private Integer state;

    private String cTag;

    private String title;

    private String content;
}