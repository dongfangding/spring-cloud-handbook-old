package com.ddf.cloud.handbook.usercenter.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddf.cloud.handbook.api.model.usercenter.AuthUser;
import com.ddf.cloud.handbook.core.exception.BadRequestException;
import com.ddf.cloud.handbook.core.util.IdsUtil;
import com.ddf.cloud.handbook.core.util.SecureUtil;
import com.ddf.cloud.handbook.usercenter.bo.AuthUserRegistryBo;
import com.ddf.cloud.handbook.usercenter.dao.AuthUserDao;
import com.ddf.cloud.handbook.usercenter.mapper.AuthUserMapper;
import com.ddf.cloud.handbook.usercenter.service.AuthUserService;
import com.ddf.cloud.handbook.usercenter.vo.AuthUserVo;
import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class AuthUserServiceImpl extends ServiceImpl<AuthUserMapper, AuthUser> implements AuthUserService {

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

    /**
     * 用户注册
     *
     * @param authUserRegistryBo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public AuthUserVo registry(AuthUserRegistryBo authUserRegistryBo) {
        Preconditions.checkNotNull(authUserRegistryBo, "请求参数不能为空!");
        Preconditions.checkArgument(StringUtils.isNotBlank(authUserRegistryBo.getUserName()), "用户名不能为空！");
        Preconditions.checkArgument(StringUtils.isNotBlank(authUserRegistryBo.getPassword()), "密码不能为空！");

        LambdaQueryWrapper<AuthUser> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(AuthUser::getUserName, authUserRegistryBo.getUserName());
        if (count(queryWrapper) > 0) {
            throw new BadRequestException("用户已存在!");
        }

        AuthUser authUser = new AuthUser();
        BeanUtil.copyProperties(authUserRegistryBo, authUser);
        // 随机给用户生成一个盐（当然如果用户主键是提前生成的，也可以使用主键）
        String userToken = IdsUtil.getNextStrId();
        authUser.setUserToken(userToken);
        authUser.setPassword(SecureUtil.signWithHMac(authUserRegistryBo.getPassword(), userToken));
        Preconditions.checkArgument(save(authUser), "用户已存在");;
        AuthUserVo authUserVo = new AuthUserVo();
        BeanUtil.copyProperties(authUser, authUserVo);
        return authUserVo;
    }
}
