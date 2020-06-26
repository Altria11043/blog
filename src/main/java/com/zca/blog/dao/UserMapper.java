package com.zca.blog.dao;

import com.zca.blog.entities.User;
import com.zca.blog.vo.UserQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectUsers();

    List<User> selectParameterUsers(UserQueryVo vo);

    User selectName(@Param("name") String name);
}