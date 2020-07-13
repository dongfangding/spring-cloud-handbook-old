package com.ddf.cloud.handbook.usercenter.controller;

import com.ddf.cloud.handbook.core.config.GlobalProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.text.MessageFormat;

/**
 * <p>description</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2020/06/29 19:00
 */
@RestController
@RequiredArgsConstructor(onConstructor=@__(@Autowired))
@RequestMapping("user")
@RequestScope
public class AuthUserController {

    private final GlobalProperties globalProperties;

    private final Environment environment;

    @Value("${customs.user.name}")
    private String userName;

    @GetMapping("testProperties")
    public String testProperties() {
        return MessageFormat.format("author: {0}, 注入userName: {1}, 从环境变量中取userName: {2}," +
                        "从共享配置文件中读取userName: {3}",
                globalProperties.getAuthor(),
                userName,
                environment.getProperty("customs.user.name"),
                environment.getProperty("customs.shard-config.user.name")
        );
    }
}
