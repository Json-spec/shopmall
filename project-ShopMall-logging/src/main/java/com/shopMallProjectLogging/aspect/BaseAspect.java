package com.shopMallProjectLogging.aspect;

import org.aspectj.lang.annotation.Pointcut;


public abstract class BaseAspect {

    @Pointcut("@annotation(com.shopMallProjectLogging.annotation.SystemLoggling)")
    protected void controllerPointcut() {
    }
}
