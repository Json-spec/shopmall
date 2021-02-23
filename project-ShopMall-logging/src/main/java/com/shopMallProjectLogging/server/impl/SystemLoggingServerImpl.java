package com.shopMallProjectLogging.server.impl;


import com.shopMallProjectLogging.mapper.SystemLoggingMapper;
import com.shopMallProjectlogging.model.SysLog;
import com.shopMallProjectLogging.server.SystemLogglingServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemLoggingServerImpl implements SystemLogglingServer {

    @Autowired
    private SystemLoggingMapper systemLoggingMapper;

    @Override
    public int insertSelective(SysLog sysLog) {
        return systemLoggingMapper.insert(sysLog);
    }

    @Override
    public SysLog query() {

        SysLog sysLog = systemLoggingMapper.selectById(1);
        return sysLog;
    }
}
