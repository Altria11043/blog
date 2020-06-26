package com.zca.blog;

import com.zca.blog.comment.MyOSS;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Map;

@SpringBootTest
@Slf4j
public class BlogApplicationTests {

    @Resource
    private MyOSS oss;

    @Test
    void contextLoads() {
        Map<String, String> policy = oss.policy();
        log.info("oss: {}", policy);
    }

}
