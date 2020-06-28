package com.ddf.cloud.usercenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>description</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2020/06/24 16:51
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.ddf.cloud")
public class UserCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserCenterApplication.class, args);
    }
}
