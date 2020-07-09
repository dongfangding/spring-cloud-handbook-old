package com.ddf.cloud.handbook.order.controller;

import com.ddf.cloud.handbook.api.model.usercenter.AuthUser;
import com.ddf.cloud.handbook.api.sdk.usercenter.AuthUserService;
import com.ddf.cloud.handbook.core.response.ResponseData;
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
 * @date 2020/06/29 18:57
 */
@RestController
@RequestMapping("order")
@RequiredArgsConstructor(onConstructor=@__(@Autowired))
public class OrderController {

    private final AuthUserService authUserService;


    @GetMapping("listAllUser")
    public ResponseData<List<AuthUser>> listAllUser() {
        return authUserService.listAll();
    }

}