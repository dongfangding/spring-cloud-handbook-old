package com.ddf.cloud.handbook.usercenter.controller;

import com.ddf.cloud.handbook.api.model.usercenter.AuthUser;
import com.ddf.cloud.handbook.api.sdk.usercenter.AuthUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    private AuthUserService authUserService;

    @GetMapping("listAll")
    public List<AuthUser> listAll() {
        return authUserService.listAll();
    }
}
