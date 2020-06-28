package com.zca.blog.serive;

import com.zca.blog.entities.User;
import com.zca.blog.vo.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IUserService {

    List<UserViewVo> selectUserList(UserQueryVo vo);

    UserViewVo selectByid(Integer id);

    Integer updateById(UserViewVo userViewVo);

    Integer addUser(AddUserVo user);

    String updateByPwd(UpdatePwdVo vo);

    Integer DelectByid(Integer id);

    String login(HttpServletRequest request, LoginVo vo);

}
