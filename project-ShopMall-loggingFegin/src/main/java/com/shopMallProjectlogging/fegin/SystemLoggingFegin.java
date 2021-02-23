package com.shopMallProjectlogging.fegin;

/**
 * @Auther: jack
 * @Date: 2021/2/19 17:37
 * @Description:
 */

import com.shopMallProjectlogging.fegin.impl.SystemLoggingFeginClientImpl;
import com.shopMallProjectlogging.model.SysLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "logger-server" , fallbackFactory = SystemLoggingFeginClientImpl.class)
public interface SystemLoggingFegin {

    @RequestMapping("/saveSysLog")
    int savaLog(SysLog sysLog);
}