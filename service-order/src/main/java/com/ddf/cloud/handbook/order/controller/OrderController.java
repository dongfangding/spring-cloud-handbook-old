package com.ddf.cloud.handbook.order.controller;

import com.ddf.cloud.handbook.api.model.usercenter.AuthUser;
import com.ddf.cloud.handbook.api.sdk.usercenter.AuthUserSdkService;
import com.ddf.cloud.handbook.core.response.ResponseData;
import feign.Request;
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

    private final AuthUserSdkService authUserSdkService;

    private final Request.Options fiveSecondsOptions;

    /**
     * 使用配置文件设置的超时时间进行feign调用
     * @return
     */
    @GetMapping("listAllUser")
    public ResponseData<List<AuthUser>> listAllUser() {
        return authUserSdkService.listAll();
    }


    /**
     * 调用方自定义超时配置进行接口调用
     * @return
     */
    @GetMapping("listAllUserByOptions")
    public ResponseData<List<AuthUser>> listAllUserByOptions() {
        return authUserSdkService.listAll(fiveSecondsOptions);
    }

}
