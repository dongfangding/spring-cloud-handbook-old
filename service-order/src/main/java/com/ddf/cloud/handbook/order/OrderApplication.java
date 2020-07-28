package com.ddf.cloud.handbook.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * <p>description</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2020/06/29 17:30
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.ddf.cloud.handbook.order.mapper")
public class OrderApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(OrderApplication.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
