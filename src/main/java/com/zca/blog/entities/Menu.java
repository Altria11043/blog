package com.zca.blog.entities;

import lombok.Data;

import java.util.Date;

@Data
public class Menu {
    private Integer id;

    private String menuName;

    private Integer menuType;

    private Integer parentId;

    private Integer status;

    private Integer sort;

    private Date creatorTime;

    private Date updateTime;

}