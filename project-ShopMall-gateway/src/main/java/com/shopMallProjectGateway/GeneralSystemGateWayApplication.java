package com.shopMallProjectGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Auther: jack
 * @Date: 2021/2/19 17:53
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GeneralSystemGateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GeneralSystemGateWayApplication.class,args);
    }
}
