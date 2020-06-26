package com.zca.blog.comment;

import com.google.code.kaptcha.Constants;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * \xac\xed\x00\x05t\x00\x04V484
 * \xac\xed\x00\x05t\x00\x042AN0
 * \xac\xed\x00\x05t\x00\x04ROX3
 * @author Altria
 * Date: 2020/6/22 20:20
 */
@Slf4j
public class KapUtil {
//    /**
//     * 将获取到的前端参数转为string类型
//     * @param request
//     * @param key
//     * @return
//     */
//    public static String getString(HttpServletRequest request, String key) {
//        try {
//            String result = request.getParameter(key);
//            if(result != null) {
//                result = result.trim();
//            }
//            if("".equals(result)) {
//                result = null;
//            }
//            return result;
//        }catch(Exception e) {
//            return null;
//        }
//    }
    /**
     * 验证码校验
     * @param request
     * @return
     */
    public static boolean checkVerifyCode(HttpServletRequest request, String kap) {
        //获取生成的验证码
        String verifyCodeExpected = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        //获取用户输入的验证码
//        String verifyCodeActual = KapUtil.getString(request, "kap");
        if(kap == null ||!kap.equalsIgnoreCase(verifyCodeExpected)) {
            return false;
        }
        return true;
    }
}
