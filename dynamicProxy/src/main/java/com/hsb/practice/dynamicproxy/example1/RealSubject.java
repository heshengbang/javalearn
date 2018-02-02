package com.hsb.practice.dynamicproxy.example1;/*
 * Copyright ©2011-2016 hsb
 */

public class RealSubject implements Subject{
    @Override
    public void rent() {
        System.out.println("I want to rent my house");
    }

    @Override
    public void hello(String name) {
        System.out.println("Hello : "+name);
    }
}
