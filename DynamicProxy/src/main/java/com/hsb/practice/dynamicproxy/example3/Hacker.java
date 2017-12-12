package com.hsb.practice.dynamicproxy.example3;/*
 * Copyright ©2011-2016 hsb
 */

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Hacker implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("*** I am a hacker, Let's see what the poor programmer is doing now...");
        methodProxy.invokeSuper(o, objects);
        System.out.println("*** Oh， what a poor programmer...");
        return null;
    }
}
