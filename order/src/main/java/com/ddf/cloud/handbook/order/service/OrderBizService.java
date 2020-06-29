package com.ddf.cloud.handbook.order.service;

import com.ddf.cloud.handbook.api.model.usercenter.AuthUser;
import com.ddf.cloud.handbook.api.sdk.order.OrderService;

import java.util.List;

/**
 * <p>description</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2020/06/29 18:45
 */
public interface OrderBizService extends OrderService {

    /**
     * 查询全部用户
     * @return
     */
    List<AuthUser> listAllUser();
}
