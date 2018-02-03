package com.hsb.pattern;/**
 * Created by heshengbang on 2018/2/3.
 */

/**
 * Created by heshengbang on 2018/2/3.
 * https://github.com/heshengbang
 * www.heshengbang.men
 * email: trulyheshengbang@gmail.com
 *
 * 工厂模式：使用工厂方法来替代new 产生新的对象实例
 *
 */
public class FactoryClass {
    public static ISample creator(int which){
        if (which==1) {
            return new SampleA();
        }
        else if (which==2) {
            return new SampleB();
        } else {
            return new SampleC();
        }
    }

    private static class ISample {
    }

    private static class SampleA extends ISample {
    }

    private static class SampleB extends ISample {
    }

    private static class SampleC extends ISample {
    }
}
