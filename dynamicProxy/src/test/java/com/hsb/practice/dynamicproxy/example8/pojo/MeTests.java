package com.hsb.practice.dynamicproxy.example8.pojo;/*
 * Copyright ©2011-2016 hsb
 */

import com.hsb.practice.dynamicproxy.example8.common.Sleepable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MeTests {
    public static void main(String[] args){
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("application.xml");
        Sleepable me = (Sleepable)appCtx.getBean("me");
        me.sleep();
    }
}
