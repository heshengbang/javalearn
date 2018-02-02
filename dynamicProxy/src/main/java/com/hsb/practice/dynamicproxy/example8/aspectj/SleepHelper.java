package com.hsb.practice.dynamicproxy.example8.aspectj;/*
 * Copyright ©2011-2016 hsb
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class SleepHelper {
    public SleepHelper() {

    }

    @Pointcut("execution(* com.hsb.practice.dynamicproxy.example8.common.impl..*(..))")
    public void sleeppoint() {
    }

    @Before("sleeppoint()")
    public void beforeSleep() {
        System.out.println("睡觉前要脱衣服!from aspectj");
    }

    @AfterReturning("sleeppoint()")
    public void afterSleep() {
        System.out.println("睡醒了要穿衣服!from aspectj");
    }

    @AfterThrowing(pointcut="sleeppoint()", throwing="ex")
    public void doThrowing(JoinPoint point, Throwable ex)
    {
        System.out.println("doThrowing::method "
                + point.getTarget().getClass().getName() + "."
                + point.getSignature().getName() + " throw exception");
        System.out.println(ex.getMessage());
    }
}
