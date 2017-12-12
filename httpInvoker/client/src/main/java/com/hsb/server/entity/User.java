package com.hsb.server.entity;/*
 * Copyright ©2011-2016 hsb
 */

import java.io.Serializable;

/**
 * 注意，使用rmi远程调用的时候，实体对象必须在两端保持同样的包名和类名，以及实现Serializable接口
 */
public class User implements Serializable{
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String password;
}
