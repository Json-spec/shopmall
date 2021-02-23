package com.shopMallProjectLogging.controller;



import com.shopMallProject.common.result.ResultConfig;
import com.shopMallProjectLogging.annotation.SystemLoggling;
import com.shopMallProjectlogging.model.SysLog;
import com.shopMallProjectLogging.server.SystemLogglingServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/logger")
@Api(tags = "日志管理接口")
public class SystemLoggingController {

    private static final Logger logger = LoggerFactory.getLogger(SystemLoggingController.class);

    @Autowired
    private SystemLogglingServer systemLogglingServer;

    @PostMapping("/index")
    @SystemLoggling
    @ApiOperation(value = "测试接口")
    public String getUser(){
        return UUID.randomUUID().toString();
    }

    @PostMapping("/saveSysLog")
    @ApiOperation(value = "记录api调用日志",notes = "记录api调用日志")
    public ResultConfig saveSysLog(@RequestBody SysLog sysLog){
        Boolean flage =  systemLogglingServer.insertSelective(sysLog) > 0 ? true : false ;
        if(flage){
            return new ResultConfig(200,"操作成功",null);
        }else{
            return new ResultConfig(400,"操作失败",null);
        }
    }
}
