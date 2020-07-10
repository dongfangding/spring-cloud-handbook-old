package com.ddf.cloud.handbook.core.config;

import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.concurrent.TimeUnit;

/**
 * <p>feign的配置</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2020/07/10 10:18
 */
@Configuration
public class FeignConfiguration {

    /**
     *
     * feign的默认超时时间只有1000ms,这里向容器中注入一个默认的超时时间， 客户端也可以使用配置的形式来覆盖这个默认的
     *
     * 配置方式一种是通过ribbon的形式来配置
     * ribbon:
     *   ReadTimeout: 90000
     *   ConnectTimeout: 9000
     *
     * 还可以通过feign自己的配置方式来实现, 参考原来曾经写的浅显文章， https://blog.csdn.net/yichen0429/article/details/88316014
     *
     * feign:
     *   client:
     *     config:
     *       default:
     *         readTimeout: 20200
     *         connectTimeout: 22000
     *       service-name:
     *         readTimeout: 30200
     *         connectTimeout: 32000
     *     default-to-properties: true # 默认
     *
     * @return
     */
    @Bean
    @Primary
    public Request.Options options() {
        return new Request.Options(10, TimeUnit.SECONDS, 10, TimeUnit.SECONDS, true);
    }

    /**
     *
     * feign的接口可以接受一个入参对象(Request.Options),这样就可以自定义每个接口的超时时间了，这里预定义几个参数
     * 参考 https://github.com/OpenFeign/feign/pull/970
     *
     * @return
     */
    @Bean
    public Request.Options oneSecondsOptions() {
        return new Request.Options(1, TimeUnit.SECONDS, 1, TimeUnit.SECONDS, true);
    }


    /**
     *
     * feign的接口可以接受一个入参对象(Request.Options),这样就可以自定义每个接口的超时时间了，这里预定义几个参数
     * 参考 https://github.com/OpenFeign/feign/pull/970
     *
     * @return
     */
    @Bean
    public Request.Options fiveSecondsOptions() {
        return new Request.Options(5, TimeUnit.SECONDS, 5, TimeUnit.SECONDS, true);
    }

    /**
     *
     * feign的接口可以接受一个入参对象(Request.Options),这样就可以自定义每个接口的超时时间了，这里预定义几个参数
     * 参考 https://github.com/OpenFeign/feign/pull/970
     *
     * @return
     */
    @Bean
    public Request.Options thirtySecondsOptions() {
        return new Request.Options(30, TimeUnit.SECONDS, 30, TimeUnit.SECONDS, true);
    }
}
