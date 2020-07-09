package com.ddf.cloud.handbook.usercenter;

import com.ddf.cloud.handbook.core.constant.GlobalConst;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * <p>description</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2020/06/24 16:51
 */
@SpringBootApplication(scanBasePackages = GlobalConst.GLOBAL_BASE_PACKAGE)
@EnableDiscoveryClient
@MapperScan(basePackages = "com.ddf.cloud.handbook.usercenter.mapper")
@EnableFeignClients(basePackages = "com.ddf.cloud.handbook.api.sdk")
public class UserCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserCenterApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
