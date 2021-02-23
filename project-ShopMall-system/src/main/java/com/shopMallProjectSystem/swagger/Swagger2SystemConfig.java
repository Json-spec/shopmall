package com.shopMallProjectSystem.swagger;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Auther: jack
 * @Date: 2021/2/19 15:28
 * @Description:
 */
@Configuration
@EnableSwagger2
public class Swagger2SystemConfig {
    private final String SWAGGER_SCAN_SYSTEM_PACKAGE="com.shopMallProjectSystem.controller";
    private final String SWAGGER_DES="系统接口管理";
    private final String SWAGGER_VERSION="1.0.0";
    private final String SWAGGER_GROUPNAME="2.系统接口管理";
    public static final String COPYRIGHT="©2020 Copyright. Powered By ShopMall";
    public static final String SITENAME = "ShopMall-";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)

     /*           .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_SYSTEM_PACKAGE))
                //.paths(PathSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error.*")))//错误路径不监控
                .paths(PathSelectors.regex("/.*"))// 对根下所有路径进行监控
                .build();*/

                .apiInfo(apiInfo())
                .pathMapping("/")
                .select() // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.any())// 对所有api进行监控
                //不显示错误的接口地址
                .paths(PathSelectors.regex("(?!/error.*).*"))
                .paths(PathSelectors.regex("(?!/actuator.*).*"))
                .paths(PathSelectors.regex("/.*"))// 对根下所有路径进行监控
                .build();

    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(SITENAME+SWAGGER_DES)
                .description(SWAGGER_DES)
                .version(SWAGGER_VERSION)
                .license(COPYRIGHT)
                .contact(new Contact("shopMall","https://127.0.0.1:8001","1654624759@QQ.COM"))
                .build();
    }
}
