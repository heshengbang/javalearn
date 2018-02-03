package com.hsb.pattern;/**
 * Created by heshengbang on 2018/2/3.
 */

/**
 * Created by heshengbang on 2018/2/3.
 * https://github.com/heshengbang
 * www.heshengbang.men
 * email: trulyheshengbang@gmail.com
 * 门面模式：门面模式用一个统一的接口去访问多个子系统的多个不同的接口
 */
public class Facade {
    public static void main(String[] args) {
        Facade facade = new Facade();
        /**
         * 一步操作就可以完成所有的准备工作
         */
        facade.open();
    }

    private Light light1, light2, light3;
    private Heater heater;
    private TV tv;

    public Facade() {
        light1 = new Light();
        light2 = new Light();
        light3 = new Light();
        heater = new Heater();
        tv = new TV();
    }

    public void open() {
        light1.open();
        light2.open();
        light3.open();
        heater.open();
        tv.open();
    }

    private class Light {
        void open() {
        }
    }

    private class Heater {
        void open() {
        }
    }

    private class TV {
        void open() {
        }
    }

}
