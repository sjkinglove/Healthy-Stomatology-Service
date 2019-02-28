package com.haoze.common.aspect;

import com.haoze.common.annotation.HasEmrRole;
import com.haoze.common.feign.AuthService;
import com.haoze.common.response.ResultGenerator;
import com.haoze.common.utils.HttpContextUtils;
import com.haoze.common.utils.JSONUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class HasEmrRoleAspect {

    //    @Autowired
//    LogRpcService logService;
    @Autowired
    AuthService authService;

    @Pointcut("@annotation(com.haoze.common.annotation.HasEmrRole)")
    public void logPointCut() {
    }

    @Before("logPointCut()()")
    public void beforeAdvice() {
        System.out.println("before advice is executed!");
    }

    @Around(value = "logPointCut()&&@annotation(hasEmrRole)", argNames = "point,hasEmrRole")
    public Object around(ProceedingJoinPoint point, HasEmrRole hasEmrRole) throws Throwable {
        String role = hasEmrRole.value();
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        String account = request.getHeader("zuul_account");
        if (authService.hasRole(role, account)) {
            Object result = point.proceed();
            return result;
        } else {
            return ResultGenerator.genForbiddenResult("无权限");
        }
    }

}

