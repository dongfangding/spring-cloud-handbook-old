package com.ddf.cloud.handbook.order.controller;

import com.ddf.cloud.handbook.api.model.usercenter.AuthUser;
import com.ddf.cloud.handbook.order.service.OrderBizService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
public class OrderController {

    @Resource(name = "orderBizServiceImpl")
    private OrderBizService orderBizService;


    @GetMapping("listAllUser")
    public List<AuthUser> listAllUser() {
        return orderBizService.listAllUser();
    }

}
