package com.zca.blog.dao;

import com.zca.blog.entities.MyGame;

public interface MyGameMapper {
    int deleteByPrimaryKey(Integer gId);

    int insert(MyGame record);

    int insertSelective(MyGame record);

    MyGame selectByPrimaryKey(Integer gId);

    int updateByPrimaryKeySelective(MyGame record);

    int updateByPrimaryKeyWithBLOBs(MyGame record);

    int updateByPrimaryKey(MyGame record);
}