package com.zca.blog.interceptor;

import com.zca.blog.vo.UserViewVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登入拦截器
 * @author Altria
 * Date: 2020/6/23 23:12
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 登入路径不做拦截
        if ("/login".equals(request.getRequestURI())){
            return true;
        }
        // 判断是否session中有用户信息, 如果有允许登入
        UserViewVo user = (UserViewVo) request.getSession().getAttribute("user");
        if (null == user) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
