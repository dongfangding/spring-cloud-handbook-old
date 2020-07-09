package com.ddf.cloud.handbook.order;

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
 * @date 2020/06/29 17:30
 */
@SpringBootApplication(scanBasePackages = GlobalConst.GLOBAL_BASE_PACKAGE)
@EnableDiscoveryClient
@MapperScan(basePackages = "com.ddf.cloud.handbook.order.mapper")
@EnableFeignClients(basePackages = "com.ddf.cloud.handbook.api.sdk")
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
