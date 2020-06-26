package com.zca.blog.vo;

import lombok.Data;

import java.util.List;

/**
 * @author Altria
 * Date: 2020/6/20 15:43
 */
@Data
public class ReleaseTableVo {

    private List<String> listTag;

    private String title;

    private Integer state;

    private Integer Id;
}
