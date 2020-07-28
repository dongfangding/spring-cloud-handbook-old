package com.ddf.cloud.handbook.api.config;

import com.ddf.cloud.handbook.api.constant.ApiConstant;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * <p>feign接口的自动装配类
 *
 * 如果引入该模块的服务主启动类所在的包路径正好能够扫描到该类，则该类配置成自动装配就是多余的。
 * 但是从通用性上来说，还是要配置一下自动状态
 *
 * </p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2020/07/28 09:33
 */
@Configuration
@EnableFeignClients(basePackages = ApiConstant.FEIGN_API_BASE_PACKAGES)
public class FeignAutoConfiguration {
}
