package com.zca.blog.dao;

import com.zca.blog.entities.GameClass;

public interface GameClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GameClass record);

    int insertSelective(GameClass record);

    GameClass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GameClass record);

    int updateByPrimaryKey(GameClass record);
}