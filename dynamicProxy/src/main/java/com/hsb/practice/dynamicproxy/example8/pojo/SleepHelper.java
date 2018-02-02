package com.hsb.practice.dynamicproxy.example8.pojo;/*
 * Copyright ©2011-2016 hsb
 */

public class SleepHelper {

    public void beforeSleep() {
        System.out.println("睡觉前要脱衣服!from pojo");
    }

    public void afterSleep() {
        System.out.println("睡醒了要穿衣服！from pojo");
    }

}
