package com.zca.blog.comment;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;

/**
 * 密码加密处理
 * @author Altria
 * Date: 2020/6/14 23:50
 */
public class PwdUtil {

    public static String pwdSHA(String pwd) throws UnsupportedEncodingException {
        return DigestUtils.sha1Hex(pwd.getBytes("UTF-8"));
    }

    public static String pwdMD5(String pwd) throws UnsupportedEncodingException {
        return DigestUtils.md5Hex(pwd.getBytes("UTF-8"));
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String p = "123456";
        System.out.println(pwdSHA(p));
        System.out.println(pwdMD5(p));
    }
}
