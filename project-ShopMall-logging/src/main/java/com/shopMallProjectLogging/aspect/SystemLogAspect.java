package com.shopMallProjectLogging.aspect;

import com.alibaba.fastjson.JSONObject;

import com.shopMallProject.common.utils.Constant;
import com.shopMallProject.common.utils.DateExUtils;
import com.shopMallProjectLogging.annotation.SystemLoggling;


import com.shopMallProjectlogging.fegin.SystemLoggingFegin;
import com.shopMallProjectlogging.model.SysLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * 系统日志：切面处理类
 */

@Aspect
@Component
public class SystemLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);

    @Autowired
    private SystemLoggingFegin systemLoggingFegin;


    /**
     * 标识请求方的请求头（各种代理方式）
     */
    private static final String[] HTTP_HEADER_REMOTE = {
            "X-Forwarded-For", //Squid 服务代理
            "Proxy-Client-IP", //Apache 服务代理
            "WL-Proxy-Client-IP",//WebLogic 服务代理
            "HTTP_CLIENT_IP",//服务代理
            "X-Real-IP",//nginx服务代理
            "unknown" //未知IP
    };

    private static String getRemoteAddr(HttpServletRequest request) {
        String ip = null;
        // X-Forwarded-For: Squid 服务代理
        String ipAddr = request.getHeader(HTTP_HEADER_REMOTE[0]);
        // Proxy-Client-IP: Apache 服务代理
        if (ipAddr == null || ipAddr.length() == 0 || HTTP_HEADER_REMOTE[HTTP_HEADER_REMOTE.length - 1].equals(ipAddr)) {
            ipAddr = request.getHeader(HTTP_HEADER_REMOTE[1]);
        }
        // WL-Proxy-Client-IP: WebLogic 服务代理
        if (ipAddr == null || ipAddr.length() == 0 || HTTP_HEADER_REMOTE[HTTP_HEADER_REMOTE.length - 1].equals(ipAddr)) {
            ipAddr = request.getHeader(HTTP_HEADER_REMOTE[2]);
        }
        // HTTP_CLIENT_IP: 有些服务代理
        if (ipAddr == null || ipAddr.length() == 0 || HTTP_HEADER_REMOTE[HTTP_HEADER_REMOTE.length - 1].equals(ipAddr)) {
            ipAddr = request.getHeader(HTTP_HEADER_REMOTE[3]);
        }
        // X-Real-IP: nginx 服务代理
        if (ipAddr == null || ipAddr.length() == 0 || HTTP_HEADER_REMOTE[HTTP_HEADER_REMOTE.length - 1].equals(ipAddr)) {
            ipAddr = request.getHeader(HTTP_HEADER_REMOTE[4]);
        }
        // 有些网络通过多层代理,会获取到多个IP,通常以(,)分割开来,并且第一个IP为客户端真是IP
        if (ipAddr != null && ipAddr.length() != 0) {
            ip = ipAddr.split(",")[0];
        }
        // 如果还获取不到,最后再通过request.getRemoteAddr()获取
        if (ipAddr == null || ipAddr.length() == 0 || HTTP_HEADER_REMOTE[HTTP_HEADER_REMOTE.length - 1].equals(ipAddr)) {
            ip = request.getRemoteAddr();
            ip = "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : request.getRemoteAddr();
        }
        return ip;
    }


    //定义切点 @Pointcut
    //在注解的位置切入代码
@Pointcut("@annotation( com.shopMallProjectLogging.annotation.SystemLoggling)")
    protected  void systemLog(){}

    //切面通知
    @Around("systemLog()")
    public Object Interceptor(ProceedingJoinPoint joinPoint){
        logger.info("~~~~~~~~~~~~！记录日志开始~~~~~~~~~~~~~~~~");
        Date startDate = new Date();//保存开始时间，请求处理时间
        Class<?> clazz = joinPoint.getTarget().getClass();
        String staerDateStr = DateExUtils.formatDate(startDate, DateExUtils.DATE_FORMAT_LONG_COMPACT);
         //获取目标方法所属类的代理
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        String methodName = method.getName();
        String className = clazz.getSimpleName();
        logger.info("method name : {};class name : {}", methodName, className);
        //获取切面定义，记录操作类型
        SystemLoggling annotation = method.getAnnotation(SystemLoggling.class);
        String type = annotation.type().getName();
        String description = annotation.description();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        Map<String, String[]> parameterMap = request.getParameterMap();
        String jsonString = JSONObject.toJSONString(parameterMap);//请求参数
        String remoteAddr = getRemoteAddr(request);
        logger.info("remoteAddr : {} ; parameter is  : {}", remoteAddr, jsonString);
        String hostAddress;
        try{
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        }catch (UnknownHostException e){
            e.getStackTrace();
            logger.warn("服务器ip无法被解析");
            hostAddress = "UnknownHost";
        }
        logger.info("hostAddress : {} " , hostAddress);
        String operator = "";
        if (annotation.type() == Constant.MethodType.LOGIN) {
            //登录POST，从请求参数中获取口令
            operator = request.getParameter("username");
            String password = request.getParameter("password");
            logger.info("客户端[{}]首次登录，口令：[用户名：{}，密码：{}]，请求时间：{}", hostAddress, operator, password, startDate);
        } else if (annotation.type() == Constant.MethodType.LOGOUT) {
            logger.info("当前会话注销...");
            operator = "";
        }
        String exceptionMsg = "", exceptionCode = "";
        try{
            logger.info("目标方法开始执行\n类: {}方法：{}", className, methodName);
            Object result = joinPoint.proceed();
            logger.info("~~~~~~~~~~~~~~~~~~~~~~~~~执行结束~~~~~~~~~~~~~~~~~~~~~");
            String resultToJSONstring = JSONObject.toJSONString(result);
            exceptionCode = "0";
            exceptionMsg = "SUCCESS";
            return result;
        }catch (Throwable e){
            logger.error("目标方法执行时发生异常，堆栈信息\n{}", className, methodName, e.getStackTrace());
            exceptionCode = String.valueOf(e.getStackTrace() != null ? e.getStackTrace().length : "1");
            exceptionMsg = e.getMessage() != null ? e.getMessage() : "未知异常信息\"" + e.getClass().getSimpleName() + "\"";
            return null;
        }finally{
            Date endDate = new Date();
            String endDateStr = DateExUtils.formatDate(endDate, DateExUtils.DATE_FORMAT_LONG_COMPACT);
            SysLog sysLog = new SysLog();
            sysLog.setEmpNo(operator);
            sysLog.setLogId(UUID.randomUUID().toString().replaceAll("-", ""));
            sysLog.setStartTime(staerDateStr);
            sysLog.setRequestIp(remoteAddr);
            sysLog.setOperationType(type);
            sysLog.setDescription(description);
            sysLog.setRequestUri(request.getRequestURI());
            sysLog.setRequestType(request.getMethod());
            sysLog.setClassName(className);
            sysLog.setMethodName(methodName);
            sysLog.setParams(jsonString);
            sysLog.setEndTime(endDateStr);
            sysLog.setResponseIp(hostAddress);
            sysLog.setExceptionCode(exceptionCode);
            sysLog.setExceptionMessage(exceptionMsg);
            systemLoggingFegin.savaLog(sysLog);
        }
    }

}
