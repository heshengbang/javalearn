package com.hsb.server.httpclient.web;/*
 * Copyright ©2011-2016 hsb
 */

import com.hsb.server.entity.BaseMapVo;
import com.hsb.server.entity.User;
import com.hsb.server.httpinvoker.interfaces.UserHttpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by tongheshang on 2017/10/26.
 * weibo.com/yunshixin
 * https://github.com/tongheshang
 * email: trulyheshengbang@gmail.com
 */
@RequestMapping("/httpinvoker")
@Controller
public class HttpClientController {

    @Autowired
    private UserHttpService userHttpService;

    @RequestMapping(value="/httpclient")
    @ResponseBody
    public BaseMapVo httpClientTest(String name, String password){
        System.out.println("httpclient server starting run "+"zyt"+"password");
        BaseMapVo vo = new BaseMapVo();
        List<User> users = userHttpService.getUserList();
        vo.addData("user", users);
        vo.setResult("success");
        System.out.println("httpclient server starting will stop soon");
        return vo;
    }

}
