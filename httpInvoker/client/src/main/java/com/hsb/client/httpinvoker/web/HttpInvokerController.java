package com.hsb.client.httpinvoker.web;/*
 * Copyright ©2011-2016 hsb
 */

import com.hsb.client.entity.BaseMapVo;
import com.hsb.client.httpinvoker.interfaces.UserHttpService;
import com.hsb.server.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RequestMapping(value = "/httpinvoker")
@Controller
public class HttpInvokerController {

    @RequestMapping(value = "/getUserList")
    @ResponseBody
    public BaseMapVo httpinvokerInsertUser() {
        BaseMapVo vo = new BaseMapVo();
        StringBuilder sb = new StringBuilder("");
        System.out.println("httpinvoker客户端开始调用");
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "classpath:*-context.xml");
        UserHttpService http = (UserHttpService) ctx.getBean("httpinvokerProxyFactoryBean");
        List<User> list = http.getUserList();
        for (User user: list) {
            sb.append("用户名 "+user.getUsername() +" 密码 "+user.getPassword());
        }
        System.out.println("httpinvoker客户端调用结束");
        vo.setResult("success");
        vo.setUserList(sb.toString());
        return vo;
    }


    @RequestMapping(value = "/insertUser", method = RequestMethod.GET)
    @ResponseBody
    public BaseMapVo insertUser(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        BaseMapVo vo = new BaseMapVo();
        StringBuilder sb = new StringBuilder("");
        System.out.println("httpinvoker客户端开始调用");
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "classpath:*-context.xml");
        UserHttpService http = (UserHttpService) ctx.getBean("httpinvokerProxyFactoryBean");
        http.insert(user);
        List<User> list = http.getUserList();
        for (User user1: list) {
            sb.append("用户"+(list.indexOf(user1)+1)+"名"+user1.getUsername() +" 密码 "+user1.getPassword()+" ");
        }
        System.out.println("httpinvoker客户端调用结束");
        vo.setResult("success");
        vo.setUserList(sb.toString());
        return vo;
    }
}
