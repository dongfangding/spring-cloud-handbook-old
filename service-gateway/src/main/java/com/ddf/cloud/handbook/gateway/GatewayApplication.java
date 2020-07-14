package com.ddf.cloud.handbook.gateway;

import com.ddf.cloud.handbook.core.constant.GlobalConst;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>description</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2020/07/14 15:31
 */
@SpringBootApplication(scanBasePackages = GlobalConst.GLOBAL_BASE_PACKAGE)
@EnableDiscoveryClient
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
