package com.shopMallProjectLogging.server;


import com.shopMallProjectlogging.model.SysLog;

public interface SystemLogglingServer {


    int insertSelective(SysLog sysLog);
}
