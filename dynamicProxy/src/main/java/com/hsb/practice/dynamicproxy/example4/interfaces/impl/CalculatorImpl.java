package com.hsb.practice.dynamicproxy.example4.interfaces.impl;/*
 * Copyright ©2011-2016 hsb
 */

import com.hsb.practice.dynamicproxy.example4.interfaces.Calculator;

public class CalculatorImpl implements Calculator {
    @Override
    public int calculate(int a, int b) {
        return a / b;
    }
}
