package com.hsb.java;/**
 * Created by heshengbang on 2018/4/23.
 */

import com.hsb.java.spring4.condition.ConditionConfig;
import com.hsb.java.spring4.condition.ListService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by heshengbang on 2018/4/23.
 * https://github.com/heshengbang
 * www.heshengbang.men
 * email: trulyheshengbang@gmail.com
 */
public class ConditionApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);

        ListService listService = context.getBean(ListService.class);

        System.out.println(context.getEnvironment().getProperty("os.name") + "系统下的列表命令为: " + listService.showListCmd());

        context.close();
    }
}
