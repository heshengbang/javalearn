package com.hsb.practice.dynamicproxy.example2;/*
 * Copyright ©2011-2016 hsb
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InvocationHandlerImpl implements InvocationHandler {
    private ElectricCar car;
    public InvocationHandlerImpl(ElectricCar car) {
        this.car = car;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("You are going to invoke "+method.getName()+" ...");
        method.invoke(car,args);
        System.out.println(method.getName()+" invocation has been finished");
        return null;
    }

    @Override
    public String toString() {
        return "Class InvocationHandlerImpl";
    }
}
