package com.zca.blog.controller;

import com.zca.blog.comment.MyOSS;
import com.zca.blog.comment.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Altria
 * Date: 2020/6/17 15:28
 */
@RestController
public class OssController {

    @Autowired
    private MyOSS myOSS;

    @GetMapping("/myblog/oss")
    public R getOSSPolicy() {
        return R.ok().put("data", myOSS.policy());
    }

}
