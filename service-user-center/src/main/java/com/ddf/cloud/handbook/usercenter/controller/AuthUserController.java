package com.ddf.cloud.handbook.usercenter.controller;

import com.ddf.cloud.handbook.api.model.usercenter.AuthUser;
import com.ddf.cloud.handbook.core.config.GlobalProperties;
import com.ddf.cloud.handbook.core.response.ResponseData;
import com.ddf.cloud.handbook.usercenter.service.AuthUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.List;

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
public class AuthUserController {

    private final GlobalProperties globalProperties;

    private final Environment environment;

    private final AuthUserService authUserService;

    @Value("${customs.user.name}")
    private String userName;


    /**
     * 演示主配置文件和共享配置文件的动态刷新
     * @return
     */
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

    @GetMapping("listAll")
    public ResponseData<List<AuthUser>> listAll() {
        return ResponseData.success(authUserService.listAll());
    }
}
