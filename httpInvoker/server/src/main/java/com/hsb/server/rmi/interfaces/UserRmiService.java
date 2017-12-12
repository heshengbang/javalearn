package com.hsb.server.rmi.interfaces;/*
 * Copyright ©2011-2016 hsb
 */


import com.hsb.server.entity.User;

import java.util.List;

public interface UserRmiService {
    List<User> getUserList();

    void insert(User user);
}
