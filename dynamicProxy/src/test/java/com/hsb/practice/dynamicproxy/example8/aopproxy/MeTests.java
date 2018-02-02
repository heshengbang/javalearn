package com.hsb.practice.dynamicproxy.example8.aopproxy;/*
 * Copyright ©2011-2016 hsb
 */

import com.hsb.practice.dynamicproxy.example8.common.Sleepable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MeTests {
    public static void main(String[] args){
        @SuppressWarnings("resource")
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("application.xml");
        Sleepable me = (Sleepable)appCtx.getBean("proxy");
        me.sleep();
    }
}
