package com.hsb.jdk.jdk8;
        /*
         * Copyright ©2011-2017 hsb
         */

interface Vehicle {
    default void print(){
        System.out.println("我是一辆车!");
    }

    static void blowHorn(){
        System.out.println("按喇叭!!!");
    }
}

