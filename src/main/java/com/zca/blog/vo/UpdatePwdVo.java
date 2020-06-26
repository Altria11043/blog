package com.zca.blog.vo;

import lombok.Data;

/**
 * @author Altria
 * Date: 2020/6/15 13:08
 */
@Data
public class UpdatePwdVo {

    private Integer uid;

    private String originalPwd;

    private String nowPwd;

}
