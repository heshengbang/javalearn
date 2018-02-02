package com.hsb.practice.dynamicproxy.example6.handle;/*
 * Copyright ©2011-2016 hsb
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态调用类对应的处理程序
 */
public class SubjectInvocationHandler implements InvocationHandler{
    /**
     * 代理类持有一个委托类的对象引用
     */
    private Object delegate;

    SubjectInvocationHandler(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("方法执行前");
        method.invoke(delegate, args);
        System.out.println("方法执行后");
        long end = System.currentTimeMillis();
        System.out.println("执行任务耗时 "+(end - start) +" 毫秒");
        return null;
    }
}






















