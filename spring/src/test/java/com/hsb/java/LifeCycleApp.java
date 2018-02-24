package com.hsb.java;

import com.hsb.java.spring.life.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class LifeCycleApp
{
    public static void main( String[] args )
    {

        System.out.println("开始初始化容器");
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-context.xml");

        System.out.println("xml加载完毕");
        Person person = (Person) ac.getBean("person");
        System.out.println(person);
        System.out.println("关闭容器");
        ((ClassPathXmlApplicationContext)ac).close();


//        System.out.println("开始初始化容器");
//        ConfigurableBeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring-context.xml"));
//        System.out.println("xml加载完毕");
//        //beanFactory需要手动注册beanPostProcessor类的方法
//        bf.addBeanPostProcessor(new MyBeanPostProcessor());
//        Person person = (Person) bf.getBean("person");
//        System.out.println(person);
//        System.out.println("关闭容器");
//        bf.destroySingletons();
    }
}
