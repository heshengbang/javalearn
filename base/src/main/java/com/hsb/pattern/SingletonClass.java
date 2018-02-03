package com.hsb.pattern;/**
 * Created by heshengbang on 2018/2/3.
 */

/**
 * Created by heshengbang on 2018/2/3.
 * https://github.com/heshengbang
 * www.heshengbang.men
 * email: trulyheshengbang@gmail.com
 * 单例模式的三种方式，懒汉，饿汉，双重锁
 */
public class SingletonClass{
    //lazy
    private static volatile SingletonClass instance=null;
    public static SingletonClass getInstance(){
        synchronized(SingletonClass.class){
            if(instance==null){
                instance=new SingletonClass();
            }
        }
        return instance;
    }
    private SingletonClass(){}
    //hungry
    /*
    private static final Singleton instance = new Singleton();
    private Singleton(){
        //do something
    }
    public static Singleton getInstance(){
        return instance;
    }
    */

    //double lock
    /*
    private static volatile Singleton instance=null;
    private Singleton(){
        //do something
    }
    public static  Singleton getInstance(){
        if(instance==null){
            synchronized(Singleton.class){
                if(instance==null){
                    instance=new Singleton();
                }
            }
        }
        return instance;
    }
    */
}
