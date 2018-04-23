package com.hsb.java.spring4.condition;/**
 * Created by heshengbang on 2018/4/23.
 */

/**
 * Created by heshengbang on 2018/4/23.
 * https://github.com/heshengbang
 * www.heshengbang.men
 * email: trulyheshengbang@gmail.com
 */
public class LinuxListService implements ListService {
    public String showListCmd() {
        return "ls";
    }
}
