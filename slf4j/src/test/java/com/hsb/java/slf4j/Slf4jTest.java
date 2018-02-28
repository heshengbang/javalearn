package com.hsb.java.slf4j;
        /*
         * Copyright ©2011-2017 hsb
         */


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jTest
{
    private static Logger logger = LoggerFactory.getLogger(Slf4jTest.class);

    @Test
    public void test()
    {
        logger.debug("debug()方法，看下这里logger的实例是：{}", logger.getClass());
        logger.info("info()方法，看下这里logger的实例是：{}", logger.getClass());
        logger.error("error()方法，看下这里logger的实例是：{}", logger.getClass());
    }
}
