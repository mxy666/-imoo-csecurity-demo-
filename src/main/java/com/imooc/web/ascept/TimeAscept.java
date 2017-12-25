package com.imooc.web.ascept;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * create by mxy on 2017/12/25
 */
@Aspect
@Component
public class TimeAscept {

    @Around("execution(* com.imooc.web.controller.UserController.*(..))")
    public Object handController(ProceedingJoinPoint point) throws Throwable {
        System.out.println("TimeAspect is running");
        long start = new Date().getTime();
        Object[] obgs = point.getArgs();
        for (Object o : obgs) {
            System.out.println("args is :" + o);


        }
        Object objects = point.proceed();
        System.out.println("filter need time :" + ((new Date().getTime()) - start));
        System.out.println("TimeAspect ending");

        return objects;
    }

}
