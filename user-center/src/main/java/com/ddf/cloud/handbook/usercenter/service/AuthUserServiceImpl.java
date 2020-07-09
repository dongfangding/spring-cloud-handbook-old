package com.ddf.cloud.handbook.usercenter.service;

import com.ddf.cloud.handbook.api.model.usercenter.AuthUser;
import com.ddf.cloud.handbook.api.sdk.usercenter.AuthUserService;
import com.ddf.cloud.handbook.core.response.ResponseData;
import com.ddf.cloud.handbook.usercenter.dao.AuthUserDao;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>description</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2020/06/29 17:21
 */
@Service
@RequiredArgsConstructor(onConstructor=@__(@Autowired))
public class AuthUserServiceImpl implements AuthUserService {

    @Setter
    private AuthUserDao authUserDao;


    /**
     * 查询全部用户列表
     *
     * @return
     */
    @Override
    public ResponseData<List<AuthUser>> listAll() {
        return ResponseData.success(authUserDao.listAll());
    }
}
