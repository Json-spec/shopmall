package com.shopMallProjectLogging.annotation;

import com.shopMallProject.common.utils.Constant.MethodType;

import java.lang.annotation.*;

/**
 * 自定义注解类
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)//注解在哪阶段执行
@Documented
public @interface SystemLoggling {

    MethodType type() default MethodType.EMPTY;

    String description() default "";

}



