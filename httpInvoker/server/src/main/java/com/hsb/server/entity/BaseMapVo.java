package com.hsb.server.entity;/*
 * Copyright ©2011-2016 hsb
 */

import java.util.HashMap;
import java.util.Map;

public class BaseMapVo {
    String result;

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    Map<String, Object> data;

    public void addData(String string, Object object) {
        if (this.data == null) {
            setData(new HashMap<String, Object>());
        }
        this.data.put(string, object);
    }

    public String getUserList() {
        return userList;
    }

    public void setUserList(String userList) {
        this.userList = userList;
    }

    String userList;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
