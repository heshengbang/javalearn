package com.hsb.practice.dynamicproxy.example7;/*
 * Copyright ©2011-2016 hsb
 */

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();

    Object getProxy(Class clazz) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("++++前置代理++++");
        Object result;
        try {
            result = methodProxy.invokeSuper(o, objects);
        } catch (Throwable e) {
            System.out.println("抛出异常");
            throw e;
        }
        System.out.println("----后置代理----");
        return result;
    }
}
