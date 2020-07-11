package com.ddf.cloud.handbook.usercenter.controller;

import com.ddf.cloud.handbook.api.model.usercenter.AuthUser;
import com.ddf.cloud.handbook.core.config.GlobalProperties;
import com.ddf.cloud.handbook.core.response.ResponseData;
import com.ddf.cloud.handbook.usercenter.service.AuthUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

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
@RequestScope
public class AuthUserController {

    private final AuthUserService authUserService;

    private final GlobalProperties globalProperties;

    @Value("${customs.user.name}")
    private String userName;

    @GetMapping("listAll")
    public ResponseData<List<AuthUser>> listAll() {
        return ResponseData.success(authUserService.listAll());
    }

    @GetMapping("testProperties")
    public String testProperties() {
        return MessageFormat.format("author: {0}, userName: {1}", globalProperties.getAuthor(), userName);
    }
}
