package com.hsb.practice.dynamicproxy.example2;/*
 * Copyright ©2011-2016 hsb
 */

public class ElectricCar implements Vehicle, Rechargable {
    @Override
    public void driver() {
        System.out.println("driver() from interface Vehicle");
    }

    @Override
    public void reCharge() {
        System.out.println("reCharge() from interface Rechargable");
    }

    @Override
    public String toString() {
        return "Class ElectricCar";
    }
}
