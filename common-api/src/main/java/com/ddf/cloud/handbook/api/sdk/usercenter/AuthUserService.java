package com.ddf.cloud.handbook.api.sdk.usercenter;

import com.ddf.cloud.handbook.api.constant.ApiConstant;
import com.ddf.cloud.handbook.api.model.usercenter.AuthUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * <p>description</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2020/06/29 16:26
 */
@FeignClient(name = ApiConstant.USER_CENTER_SERVICE_NAME, path = ApiConstant.USER_CENTER_SERVER_CONTEXT)
public interface AuthUserService {

    /**
     * 查询全部用户列表
     * @return
     */
    @GetMapping("/user/listAll")
    List<AuthUser> listAll();
}
