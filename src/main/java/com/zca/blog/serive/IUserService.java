package com.zca.blog.serive;

import com.zca.blog.entities.User;
import com.zca.blog.vo.LoginVo;
import com.zca.blog.vo.UpdatePwdVo;
import com.zca.blog.vo.UserQueryVo;
import com.zca.blog.vo.UserViewVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IUserService {

    List<UserViewVo> selectUserList(UserQueryVo vo);

    UserViewVo selectByid(Integer id);

    Integer updateById(UserViewVo userViewVo);

    Integer addUser(User user);

    String updateByPwd(UpdatePwdVo vo);

    Integer DelectByid(Integer id);

    String login(HttpServletRequest request, LoginVo vo);

}
