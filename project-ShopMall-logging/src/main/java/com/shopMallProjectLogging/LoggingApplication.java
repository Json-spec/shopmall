package com.shopMallProjectLogging;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Auther: jack
 * @Date: 2021/2/19 17:32
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.shopMallProjectlogging.fegin"})
@MapperScan("com.shopMallProjectLogging.mapper.*")
public class LoggingApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoggingApplication.class,args);
    }
}
