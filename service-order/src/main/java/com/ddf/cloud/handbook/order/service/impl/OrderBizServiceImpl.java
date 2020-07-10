package com.ddf.cloud.handbook.order.service.impl;

import com.ddf.cloud.handbook.api.sdk.usercenter.AuthUserSdkService;
import com.ddf.cloud.handbook.order.service.OrderBizService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>description</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2020/06/29 19:04
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderBizServiceImpl implements OrderBizService {

    private final AuthUserSdkService authUserSdkService;

}
