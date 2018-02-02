package com.hsb.practice.dynamicproxy.example5.main;/*
 * Copyright ©2011-2016 hsb
 */

import com.hsb.practice.dynamicproxy.example5.impl.WXAgent;
import com.hsb.practice.dynamicproxy.example5.interfaces.Sell;

public class MainTest {
    public static void main(String[] args) {
        Sell agent = new WXAgent();
        agent.sell();
        agent.add();
    }
}
