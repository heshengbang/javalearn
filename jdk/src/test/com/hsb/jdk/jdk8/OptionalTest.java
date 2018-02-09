package com.hsb.jdk.jdk8;
        /*
         * Copyright ©2011-2017 hsb
         */

import java.util.Optional;

public class OptionalTest {
    public static void main(String args[]) {

        OptionalTest java8Tester = new OptionalTest();
        Integer value1 = null;
        Integer value2 = 10;

        // Optional.ofNullable - 允许传递为 null 参数
        Optional<Integer> a = Optional.ofNullable(value1);

        // Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
        Optional<Integer> b = Optional.of(value2);
        System.out.println(java8Tester.sum(a, b));
    }

    private Integer sum(Optional<Integer> a, Optional<Integer> b) {

        // Optional.isPresent - 判断值是否存在

        System.out.println("第一个参数值存在: " + a.isPresent());
        System.out.println("第二个参数值存在: " + b.isPresent());

        // Optional.orElse - 如果值存在，返回它，否则返回默认值
        Integer value1 = a.orElse(0);

        //Optional.get - 获取值，值需要存在
        /*if (b.isPresent()) {
            return value1 + b.get();
        } else {
            return value1;
        }*/
        //map
        return b.map(integer -> value1 + integer).orElse(value1);
    }
}
