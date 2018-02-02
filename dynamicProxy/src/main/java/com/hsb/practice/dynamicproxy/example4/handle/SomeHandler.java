package com.hsb.practice.dynamicproxy.example4.handle;/*
 * Copyright ©2011-2016 hsb
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SomeHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxy, args);
    }
}
