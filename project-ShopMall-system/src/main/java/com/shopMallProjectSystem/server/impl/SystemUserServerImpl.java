package com.shopMallProjectSystem.server.impl;


import com.shopMallProjectSystem.mapper.SystemUserMapper;
import com.shopMallProjectSystem.server.SystemUserServer;
import org.springframework.beans.factory.annotation.Autowired;

public class SystemUserServerImpl implements SystemUserServer {

    @Autowired
    private SystemUserMapper systemUserMapper;


}
