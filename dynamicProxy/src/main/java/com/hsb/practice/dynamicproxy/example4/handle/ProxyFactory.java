package com.hsb.practice.dynamicproxy.example4.handle;/*
 * Copyright ©2011-2016 hsb
 */

import com.hsb.practice.dynamicproxy.example4.aop.AbstractHandler;

import java.lang.reflect.Proxy;
import java.util.List;

public class ProxyFactory {

    /**
     * Gets the proxy.
     *
     * @param targetObject the target object
     * @param handlers the handlers
     * @return the proxy
     */
    public static Object getProxy(Object targetObject,
                                  List<AbstractHandler> handlers) {
        Object proxyObject;
        if (handlers.size() > 0) {
            proxyObject = targetObject;
            for (AbstractHandler handler : handlers) {
                handler.setTargetObject(proxyObject);
                proxyObject = Proxy.newProxyInstance(targetObject.getClass()
                        .getClassLoader(), targetObject.getClass()
                        .getInterfaces(), handler);
            }
            return proxyObject;
        } else {
            return targetObject;
        }
    }
}
