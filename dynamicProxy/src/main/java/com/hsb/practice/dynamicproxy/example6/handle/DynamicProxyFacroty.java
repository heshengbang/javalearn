package com.hsb.practice.dynamicproxy.example6.handle;/*
 * Copyright ©2011-2016 hsb
 */

import com.hsb.practice.dynamicproxy.example1.RealSubject;
import com.hsb.practice.dynamicproxy.example1.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 生成动态代理对象的工厂类
 */
public class DynamicProxyFacroty {
    //客户类调用此工厂方法获得代理对象
    //对于客户类来说，并不知道返回的是代理对象还是委托类对象
    public static Subject getInstance() {
        Subject delegate = new RealSubject();
        InvocationHandler handler = new SubjectInvocationHandler(delegate);
        Subject proxy;
        proxy = (Subject) Proxy.newProxyInstance(delegate.getClass().getClassLoader(),
                delegate.getClass().getInterfaces(),
                handler);
        return proxy;
    }
}