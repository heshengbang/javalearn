package com.hsb.java.spring.life;
        /*
         * Copyright ©2011-2017 hsb
         */

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Person implements BeanNameAware, BeanFactoryAware,
        ApplicationContextAware, InitializingBean, DisposableBean {

    private String name;

    public Person() {
        System.out.println("Person类构造方法");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("set方法被调用");
    }

    public String getName() {
        return name;
    }

    private void myInit() {
        System.out.println("myInit被调用");
    }

    private void myDestroy() {
        System.out.println("myDestroy被调用");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destory被调用");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet被调用");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext被调用");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory被调用,beanFactory");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("setBeanName被调用,beanName:" + s);
    }

    public String toString() {
        return "name is :" + name;
    }
}
