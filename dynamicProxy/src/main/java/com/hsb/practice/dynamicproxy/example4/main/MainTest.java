package com.hsb.practice.dynamicproxy.example4.main;/*
 * Copyright ©2011-2016 hsb
 */

import com.hsb.practice.dynamicproxy.example4.aop.AbstractHandler;
import com.hsb.practice.dynamicproxy.example4.aop.AfterHandler;
import com.hsb.practice.dynamicproxy.example4.aop.BeforeHandler;
import com.hsb.practice.dynamicproxy.example4.aop.impl.AfterHandlerImpl;
import com.hsb.practice.dynamicproxy.example4.aop.impl.BeforeHandlerImpl;
import com.hsb.practice.dynamicproxy.example4.handle.ProxyFactory;
import com.hsb.practice.dynamicproxy.example4.interfaces.Calculator;
import com.hsb.practice.dynamicproxy.example4.interfaces.impl.CalculatorImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.importnew.com/15420.html
 * http://blog.csdn.net/giserstone/article/details/17199755
 */
public class MainTest {
    public static void main(String[] args) {
        CalculatorImpl calcImpl = new CalculatorImpl();
        BeforeHandler before = new BeforeHandlerImpl();
        AfterHandler after = new AfterHandlerImpl();
        List<AbstractHandler> handlers = new ArrayList<AbstractHandler>();
        handlers.add(before);
        handlers.add(after);
        Calculator proxy = (Calculator) ProxyFactory.getProxy(calcImpl,
                handlers);
        int result = proxy.calculate(20, 10);
        System.out.println("Final Result :::" + result);
    }
}
