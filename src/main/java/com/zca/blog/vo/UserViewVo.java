package com.zca.blog.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 返回User列表需要展示的数据
 * @author Altria
 * Date: 2020/6/13 19:43
 */
@Data
public class UserViewVo implements Serializable {
    private static final long serialVersionUID = -8266355414048184503L;
    private Integer id;

    private String userName;

    private String email;

    private String phone;

    private Date creatorTime;

    private String photo;

    private String comment;

    private Integer status;

    private Integer worksNum;

}
