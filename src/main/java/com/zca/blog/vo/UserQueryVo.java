package com.zca.blog.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author Altria
 * Date: 2020/6/25 16:12
 */
@Data
public class UserQueryVo {

    private String content;
    private Date startDate;
    private Date endDate;

}
