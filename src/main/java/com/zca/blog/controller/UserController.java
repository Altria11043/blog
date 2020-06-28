package com.zca.blog.controller;

import com.zca.blog.comment.R;
import com.zca.blog.entities.User;
import com.zca.blog.serive.IUserService;
import com.zca.blog.vo.AddUserVo;
import com.zca.blog.vo.UpdatePwdVo;
import com.zca.blog.vo.UserQueryVo;
import com.zca.blog.vo.UserViewVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Altria
 * Date: 2020/6/6 15:43
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 根据条件返回用户
     * @return
     */
    @GetMapping("/list")
    public R selectUserList(UserQueryVo vo) {
        log.info("查询条件: {}", vo);
        List<UserViewVo> userViewVos = userService.selectUserList(vo);
        return R.ok().put("data",userViewVos);
    }

    @GetMapping("/id")
    public R selectById(@RequestParam("id") Integer id) {
        UserViewVo userViewVo = userService.selectByid(id);
        return R.ok().put("data", userViewVo);
    }

    /**
     * 更新用户信息
     * @param userViewVo
     * @return
     */
    @PostMapping("/update")
    public R updateById(HttpServletRequest request,
                        @RequestBody UserViewVo userViewVo){
        log.info("userViewVo: {}", userViewVo);
        request.getSession().setAttribute("user", userViewVo);
        Integer integer = userService.updateById(userViewVo);
        return R.ok().put("data", integer);
    }

    /**
     * 添加用户信息
     * @return
     */
    @PostMapping("/add")
    public R addUser(@RequestBody AddUserVo userVo){
        Integer integer = userService.addUser(userVo);
        return R.ok().put("data", integer);
    }

    /**
     * 更改密码
     * @return
     */
    @PostMapping("/update/pwd")
    public R updateByPwd(@RequestBody UpdatePwdVo vo)  {
        String msg = userService.updateByPwd(vo);
        return R.ok().put("data", msg);
    }

    @PostMapping("/delect")
    public R delectById(@RequestParam("id") Integer id) {
        Integer res = userService.DelectByid(id);
        return R.ok().put("data", res);
    }

    @GetMapping("/photo")
    public R getPhoto(HttpServletRequest request) {
        UserViewVo user = (UserViewVo) request.getSession().getAttribute("user");
        return R.ok().put("data", user.getPhoto());
    }
}
