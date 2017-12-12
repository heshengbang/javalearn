package com.hsb.client.httpclient.web;/*
 * Copyright ©2011-2016 hsb
 */

import com.hsb.client.entity.BaseMapVo;
import com.hsb.client.httpclient.util.HttpClientUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;

/**
 * Created by tongheshang on 2017/10/26.
 * weibo.com/yunshixin
 * https://github.com/tongheshang
 * email: trulyheshengbang@gmail.com
 */
@RequestMapping("/httpclient")
@Controller
public class HttpClientController {

    @ResponseBody
    @RequestMapping("/httpclient")
    public BaseMapVo httpClientTest() {
        String name = "tongheshang";
        String password = "password";
        BaseMapVo vo = new BaseMapVo();
        long startDate = Calendar.getInstance().getTimeInMillis();
        System.out.println("httpInvoker客户端开始调用" + startDate);
        String path="http://localhost:8080/server/httpclient/httpclient";
        HttpClientUtil httpClientUtil = new  HttpClientUtil(name, password, path);
        new Thread(httpClientUtil).start();
//     UserHttpService rmi = (UserHttpService)ApplicationContextUtil.getInstance().getBean("httpInvokerProxy");
//     rmi.getUserByAcount("张三", ":张三的密码");
        System.out.println("httpInvoker客户端调用结束" +  (Calendar.getInstance().getTimeInMillis()-startDate));
        vo.setResult("sucess");
        return vo;
    }
}
