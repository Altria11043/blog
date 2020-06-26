package com.zca.blog.dao;

import com.zca.blog.entities.Menu;
import org.apache.ibatis.annotations.Param;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(@Param("id") Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}