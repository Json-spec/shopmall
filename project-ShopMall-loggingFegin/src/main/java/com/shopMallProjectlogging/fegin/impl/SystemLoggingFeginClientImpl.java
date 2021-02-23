package com.shopMallProjectlogging.fegin.impl;



import com.shopMallProjectlogging.fegin.SystemLoggingFegin;
import com.shopMallProjectlogging.model.SysLog;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class SystemLoggingFeginClientImpl implements FallbackFactory<SystemLoggingFegin> {
    @Override
    public SystemLoggingFegin create(Throwable throwable) {
        return new SystemLoggingFegin() {
            @Override
            public int savaLog(SysLog sysLog) {
                return 0;
            }
        };
    }
}
