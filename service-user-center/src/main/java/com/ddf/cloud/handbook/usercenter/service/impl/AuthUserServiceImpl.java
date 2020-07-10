package com.ddf.cloud.handbook.usercenter.service.impl;

import com.ddf.cloud.handbook.api.model.usercenter.AuthUser;
import com.ddf.cloud.handbook.usercenter.dao.AuthUserDao;
import com.ddf.cloud.handbook.usercenter.service.AuthUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>description</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2020/07/10 10:55
 */
@Service
@RequiredArgsConstructor(onConstructor=@__(@Autowired))
public class AuthUserServiceImpl implements AuthUserService {

    private final AuthUserDao authUserDao;

    /**
     * 查询全部用户列表
     *
     * @return
     */
    @Override
    public List<AuthUser> listAll() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return authUserDao.listAll();
    }
}
