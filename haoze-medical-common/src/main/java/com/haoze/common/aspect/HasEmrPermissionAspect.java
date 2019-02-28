package com.haoze.common.aspect;

import com.haoze.common.annotation.HasEmrPermission;
import com.haoze.common.annotation.HasEmrRole;
import com.haoze.common.feign.AuthService;
import com.haoze.common.response.ResultGenerator;
import com.haoze.common.utils.HttpContextUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HasEmrPermissionAspect {

    //    @Autowired
//    LogRpcService logService;
    @Autowired
    AuthService authService;

    @Pointcut("@annotation(com.haoze.common.annotation.HasEmrPermission)")
    public void logPointCut() {
    }

    @Before("logPointCut()()")
    public void beforeAdvice() {
        System.out.println("before advice is executed!");
    }

    @Around(value = "logPointCut()&&@annotation(hasEmrPermission)", argNames = "point,hasEmrPermission")
    public Object around(ProceedingJoinPoint point, HasEmrPermission hasEmrPermission) throws Throwable {
        String permission = hasEmrPermission.value();
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        String account = request.getHeader("zuul_account");
        if (authService.hasPermission(permission, account)) {
            Object result = point.proceed();
            return result;
        } else {
            return ResultGenerator.genForbiddenResult("无权限");
        }
    }

}

