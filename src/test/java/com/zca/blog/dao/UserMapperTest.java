package com.zca.blog.dao;

import com.zca.blog.BlogApplicationTests;
import com.zca.blog.entities.User;
import com.zca.blog.serive.IUserService;
import com.zca.blog.vo.UpdatePwdVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
public class UserMapperTest extends BlogApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private IUserService userService;

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
        User user = userMapper.selectByPrimaryKey(1);
        log.info("user: {}", user);
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void selectUsers() {
        List<User> users = userMapper.selectUsers();
        log.info("users: {}", users);
    }

    @Test
    public void updateByPwd() {
        UpdatePwdVo vo = new UpdatePwdVo();
        vo.setUid(1);
        vo.setOriginalPwd("admin");
        vo.setNowPwd("zhou@11043");
        String msg = userService.updateByPwd(vo);
        log.info("消息: {}", msg);
    }
}