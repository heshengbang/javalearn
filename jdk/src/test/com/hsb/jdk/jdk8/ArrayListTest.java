package com.hsb.jdk.jdk8;
        /*
         * Copyright ©2011-2017 hsb
         */

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("FUck");
        list.add("shit");
        list.add("bastard");

//        for (String string: list) {
//            System.out.println(string);
//            list.remove(string);
//            list.add("FUCK again");
//        }

        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
        }

        for (String string : list) {
            System.out.println(string);
        }
    }
}
