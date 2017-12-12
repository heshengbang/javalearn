package com.hsb.practice.dynamicproxy.example5.impl;/*
 * Copyright ©2011-2016 hsb
 */

import com.hsb.practice.dynamicproxy.example5.interfaces.Sell;

public class WXAgent implements Sell{
    private Sell boss;

    @Override
    public void sell() {

        if (boss == null) {
            boss = new Boss();
        }
        preRequest();
        boss.sell();
        postRequest();
    }

    @Override
    public void add() {
        if (boss == null) {
            boss = new Boss();
        }
        preRequest();
        boss.add();
        postRequest();
    }

    private void preRequest()
    {
        System.out.println("Pre Execution.");
    }
    private void postRequest()
    {
        System.out.println("Post Execution.");
    }
}
