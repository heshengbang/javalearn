package com.hsb.jni;/*
 * Copyright ©2011-2016 hsb
 */

/**
 * Created by tongheshang on 2018/1/3.
 * https://twitter.com/heshengbang
 * https://github.com/tongheshang
 * email: trulyheshengbang@gmail.com
 */
public class HelloWorld {
    //All native means function or attribute belongs to local
    public native void displayHelloWorld();
    static {
        //load in local system library
        System.loadLibrary("hello");
    }
    public static void main(String[] args) {
        new HelloWorld().displayHelloWorld();
    }
}