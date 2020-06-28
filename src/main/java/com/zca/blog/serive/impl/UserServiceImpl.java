package com.zca.blog.serive.impl;

import com.zca.blog.comment.PwdUtil;
import com.zca.blog.dao.UserMapper;
import com.zca.blog.entities.User;
import com.zca.blog.serive.IUserService;
import com.zca.blog.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Altria
 * Date: 2020/6/13 15:32
 */
@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<UserViewVo> selectUserList(UserQueryVo vo) {

        List<User> users = userMapper.selectParameterUsers(vo);

        List<UserViewVo> userViewVos = users.stream().map(user -> {
            UserViewVo userViewVo = new UserViewVo();
            BeanUtils.copyProperties(user, userViewVo);
            return userViewVo;
        }).collect(Collectors.toList());
        return userViewVos;
    }

    @Override
    public UserViewVo selectByid(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        UserViewVo userViewVo = new UserViewVo();
        BeanUtils.copyProperties(user, userViewVo);
        return userViewVo;
    }

    @Transactional
    @Override
    public Integer updateById(UserViewVo userViewVo) {

        User user = new User();
        BeanUtils.copyProperties(userViewVo, user);
        int i = userMapper.updateByPrimaryKeySelective(user);
        return i;
    }

    @Transactional
    @Override
    public Integer addUser(AddUserVo userVo) {
        User user = new User();
        BeanUtils.copyProperties(userVo, user);
        try {
            String pwdSHA = PwdUtil.pwdSHA(user.getPassword());
            user.setPassword(pwdSHA);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        user.setStatus(1);
        return userMapper.insertSelective(user);
    }

    /**
     * 更改用户密码
     *
     * @param vo
     */
    @Transactional
    @Override
    public String updateByPwd(UpdatePwdVo vo) {
        User user = userMapper.selectByPrimaryKey(vo.getUid());
        String oPwd = "";
        String nPwd = "";
        try {
            oPwd = PwdUtil.pwdSHA(vo.getOriginalPwd());
            nPwd = PwdUtil.pwdSHA(vo.getNowPwd());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        // 先对比原来密码是否正确, 正确则修改
        if (user.getPassword().equals(oPwd)) {
            user.setPassword(nPwd);
            userMapper.updateByPrimaryKeySelective(user);
            return "更改密码成功";
        }
        return "原密码不正确";
    }

    @Transactional
    @Override
    public Integer DelectByid(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public String login(HttpServletRequest request, LoginVo vo) {
//        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
//        String kap = opsForValue.get("kap");
//        if (kap.equals(vo.getKap())){
//            return "ERR_KAP";
//        }
        User user = userMapper.selectName(vo.getName());
        try {
            if (user != null) {
                String pwdSHA = PwdUtil.pwdSHA(vo.getPass());
                boolean equals = pwdSHA.equals(user.getPassword());
                if (!equals) {
                    return "ERR_PWD";
                }else{
                    // 如果成功则将当前用户的登入信息保存到session中
                    UserViewVo userViewVo = new UserViewVo();
                    BeanUtils.copyProperties(user, userViewVo);
                    request.getSession().setAttribute("user", userViewVo);
                    return "SUCCESS";
                }
            } else {
                return "ERR_NAME";
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return "ERROR";
    }

}
