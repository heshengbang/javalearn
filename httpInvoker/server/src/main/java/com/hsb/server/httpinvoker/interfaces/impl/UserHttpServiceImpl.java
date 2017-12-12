package com.hsb.server.httpinvoker.interfaces.impl;/*
 * Copyright ©2011-2016 hsb
 */

import com.hsb.server.entity.User;
import com.hsb.server.httpinvoker.interfaces.UserHttpService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserHttpServiceImpl implements UserHttpService {

    private ArrayList<User> userList;

    @Override
    public List<User> getUserList() {
        if (userList == null) {
            userList = new ArrayList<User>();
        }
        System.err.println("httpInvoker获取用户信息");
        return userList;
    }

    @Override
    public void insert(User user) {
        if (userList == null) {
            userList = new ArrayList<User>();
        }
        System.err.println("HttpInvoker开始插入");
        userList.add(user);
        System.err.println("HttpInvoker完成插入");
    }
}
