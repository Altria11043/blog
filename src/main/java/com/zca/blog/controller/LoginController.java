package com.zca.blog.controller;

import com.zca.blog.comment.KapUtil;
import com.zca.blog.comment.R;
import com.zca.blog.serive.IUserService;
import com.zca.blog.vo.LoginVo;
import com.zca.blog.vo.UserViewVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Altria
 * Date: 2020/6/22 4:04
 */
@RestController
public class LoginController {

    @Autowired
    private IUserService userService;

    @GetMapping("/login")
    public R login(HttpServletRequest request,
                   LoginVo vo) {
        if (!KapUtil.checkVerifyCode(request, vo.getKap())){
            return R.ok().put("data", "ERR_KAP");
        }
        String state = userService.login(request, vo);
        return R.ok().put("data", state);
    }

    @GetMapping("/get/session")
    public R getSessionState(HttpServletRequest request) {
        UserViewVo user = (UserViewVo) request.getSession().getAttribute("user");
        if (user != null) {
            return R.ok().put("data", true);
        }
        return R.ok().put("data", false);
    }

    @GetMapping("/clear/session")
    public R clearSession(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return R.ok().put("data", "SUCCESS");
    }

}
