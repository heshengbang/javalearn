package com.hsb.jdk.jdk8;
        /*
         * Copyright ©2011-2017 hsb
         */

class Car implements Vehicle, FourWheeler {
    public void print(){
        Vehicle.super.print();
        FourWheeler.super.print();
        Vehicle.blowHorn();
        System.out.println("我是一辆汽车!");
    }
}
