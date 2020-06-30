package com.ddf.cloud.handbook.order.service.impl;

import com.ddf.cloud.handbook.api.model.usercenter.AuthUser;
import com.ddf.cloud.handbook.api.sdk.usercenter.AuthUserService;
import com.ddf.cloud.handbook.order.service.OrderBizService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    private final AuthUserService authUserService;

    /**
     * 查询全部用户
     *
     * @return
     */
    @Override
    public List<AuthUser> listAllUser() {
        return authUserService.listAll();
    }
}
