package com.zca.blog.serive.impl;

import com.zca.blog.BlogApplicationTests;
import com.zca.blog.serive.IUserService;
import com.zca.blog.vo.UserQueryVo;
import com.zca.blog.vo.UserViewVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

@Slf4j
public class UserServiceImplTest extends BlogApplicationTests {

    @Autowired
    private IUserService userService;

    @Test
    public void selectUserList() {
        UserQueryVo vo = new UserQueryVo();
        List<UserViewVo> userViewVos = userService.selectUserList(vo);
        log.info("USER: {}", userViewVos);
    }

    @Test
    public void selectByid() {
    }

    @Test
    public void updateById() {
    }

    @Test
    public void addUser() {
    }

    @Test
    public void updateByPwd() {
    }

    @Test
    public void delectByid() {
    }

    @Test
    public void login() {
    }
}