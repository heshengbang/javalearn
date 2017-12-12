package com.hsb.practice.dynamicproxy.example6.main;/*
 * Copyright ©2011-2016 hsb
 */

import com.hsb.practice.dynamicproxy.example1.Subject;
import com.hsb.practice.dynamicproxy.example6.handle.DynamicProxyFacroty;

public class Client {
    public static void main(String[] args) {
        Subject proxy = DynamicProxyFacroty.getInstance();
        proxy.rent();
        proxy.hello("Monica");
    }
}
