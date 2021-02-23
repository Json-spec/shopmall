package com.shopMallProjectSystem.controller;


import com.shopMallProjectLogging.annotation.SystemLoggling;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Api(tags = "系统管理接口Controller")
@RestController
@RequestMapping("/system")
public class SystemUserController {

    private static final Logger logger = LoggerFactory.getLogger(SystemUserController.class);

    @PostMapping("/index")
    @SystemLoggling
    @ApiOperation(value = "测试接口")
    public String getUser(){
        return UUID.randomUUID().toString();
        /*ResultConfig<User> userById = systemUserFeginClient.getUserById(id);
        return userById;*/
    }
    @PostMapping("/index2")
    @SystemLoggling
    @ApiOperation(value = "测试接口")
    public String getUse1r(){
        return UUID.randomUUID().toString();
        /*ResultConfig<User> userById = systemUserFeginClient.getUserById(id);
        return userById;*/
    }

    @PostMapping("/index1")
    @SystemLoggling
    public String getUser1(){
        return "shabi";
    }
}
