package com.ddf.cloud.handbook.usercenter.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddf.cloud.handbook.api.model.usercenter.AuthUser;
import com.ddf.cloud.handbook.usercenter.mapper.AuthUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>专注于mybatis的简单查询方法暴露</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2020/06/29 11:06
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthUserDao extends ServiceImpl<AuthUserMapper, AuthUser> {

    private AuthUserMapper authUserMapper;


    /**
     * 查询全部用户
     *
     * @return java.util.List<com.ddf.cloud.handbook.api.model.usercenter.AuthUser>
     * @author dongfang.ding
     * @date 2020/6/29 0029 17:18
     **/
    public List<AuthUser> listAll() {
        return authUserMapper.selectList(null);
    }
}
