package com.hsb.practice.dynamicproxy.example8.common.impl;/*
 * Copyright ©2011-2016 hsb
 */

import com.hsb.practice.dynamicproxy.example8.common.Sleepable;

public class Me implements Sleepable{
    @Override
    public void sleep() {
        System.out.println("\n睡觉！不休息哪里有力气学习！\n");
    }
}
