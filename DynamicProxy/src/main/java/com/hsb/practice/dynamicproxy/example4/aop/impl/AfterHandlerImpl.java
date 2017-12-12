package com.hsb.practice.dynamicproxy.example4.aop.impl;/*
 * Copyright ©2011-2016 hsb
 */

import com.hsb.practice.dynamicproxy.example4.aop.AfterHandler;

import java.lang.reflect.Method;

public class AfterHandlerImpl extends AfterHandler {

    /* (non-Javadoc)
     * @see com.ddlab.rnd.aop.AfterHandler#handleAfter(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
     */
    @Override
    public void handleAfter(Object proxy, Method method, Object[] args) {
        //Provide your own cross cutting concern
        System.out.println("Handling after actual method execution ........");
    }
}