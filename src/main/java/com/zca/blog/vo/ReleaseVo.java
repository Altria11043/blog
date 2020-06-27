package com.zca.blog.vo;

import lombok.Data;

import java.util.List;

/**
 * @author Altria
 * Date: 2020/6/19 13:57
 */
@Data
public class ReleaseVo {

    private String content;

    private Integer state;

    private List<String> listTag;

    private String title;

    private Integer id;
}
