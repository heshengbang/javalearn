package com.hsb.practice.dynamicproxy.example5.impl;/*
 * Copyright ©2011-2016 hsb
 */

import com.hsb.practice.dynamicproxy.example5.interfaces.Sell;

public class Boss implements Sell {
    @Override
    public void sell() {
        System.out.println("Boss - sell()");
    }

    @Override
    public void add() {
        System.out.println("Boss - add()");
    }
}
