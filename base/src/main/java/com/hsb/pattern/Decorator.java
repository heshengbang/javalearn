package com.hsb.pattern;
        /*
         * Copyright ©2011-2017 hsb
         */

public class Decorator {
    public static void main(String[] args) {
//        Beverage beverage = new Espresso();
//        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

//        Beverage beverage3 = new HouseBlend();
//        beverage3 = new Soy(beverage2);
//        beverage3 = new Mocha(beverage2);
//        beverage3 = new Whip(beverage2);
//        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
    }
}

abstract class Beverage {
    /**
     * 饮料的名称，用来代表是哪种饮料
     */
    protected String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    /**
     * 每个子类都有自己的实现方法
     *
     * @return 花費
     */
    public abstract double cost();
}

abstract class CondimentDecorator extends Beverage {
    public abstract String getDescription();
}

class Mocha extends CondimentDecorator {
    /**
     * 保留一个被装饰者的引用
     */
    private Beverage beverage;

    Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    public double cost() {
        return .20 + beverage.cost();
    }
}

class Whip extends CondimentDecorator {
    /**
     * 保留一个被装饰者的引用
     */
    private Beverage beverage;

    Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    /**
     * 每个子类都有自己的实现方法
     *
     * @return 花費
     */
    @Override
    public double cost() {
        return .20 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }
}

class DarkRoast extends Beverage {

    DarkRoast() {
        description = "DarkRoast";
    }

    public double cost() {
        return .99;
    }
}