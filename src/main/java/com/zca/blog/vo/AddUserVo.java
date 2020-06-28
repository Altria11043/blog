package com.zca.blog.vo;

import lombok.Data;

/**
 * @author Altria
 * Date: 2020/6/28 16:11
 */
@Data
public class AddUserVo {
    private String photo;
    private String userName;
    private String password;
    private String email;
    private String phone;
    private String comment;
}
