package com.hsb.practice.dynamicproxy.example7;/*
 * Copyright ©2011-2016 hsb
 */

class SayHello {
    void say() {
        System.out.println("hello everyone");
        throw new NullPointerException("XX");
    }
}
