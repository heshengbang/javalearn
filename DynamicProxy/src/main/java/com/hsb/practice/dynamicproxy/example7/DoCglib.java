package com.hsb.practice.dynamicproxy.example7;/*
 * Copyright ©2011-2016 hsb
 */

public class DoCglib {
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        SayHello proxyImpl = (SayHello) proxy.getProxy(SayHello.class);
        proxyImpl.say();
    }
}
