package com.hsb.server.httpinvoker.interfaces;/*
 * Copyright ©2011-2016 hsb
 */

import com.hsb.server.entity.User;

import java.util.List;

public interface UserHttpService {
    List<User> getUserList();

    void insert(User user);
}
