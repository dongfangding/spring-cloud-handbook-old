package com.ddf.cloud.handbook.usercenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ddf.cloud.handbook.api.model.usercenter.AuthUser;
import com.ddf.cloud.handbook.usercenter.bo.AuthUserRegistryBo;
import com.ddf.cloud.handbook.usercenter.vo.AuthUserVo;

import java.util.List;

/**
 * <p>description</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2020/07/10 10:54
 */
public interface AuthUserService extends IService<AuthUser> {


    /**
     * 查询全部用户列表
     * @return
     */
    List<AuthUser> listAll();


    /**
     * 用户注册
     *
     * @param authUserRegistryBo
     * @return
     */
    AuthUserVo registry(AuthUserRegistryBo authUserRegistryBo);
}
