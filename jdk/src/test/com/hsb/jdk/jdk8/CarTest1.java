package com.hsb.jdk.jdk8;/**
 * Created by heshengbang on 2018/2/7.
 */

import object.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by heshengbang on 2018/2/7.
 * https://github.com/heshengbang
 * www.heshengbang.men
 * email: trulyheshengbang@gmail.com
 */
public class CarTest1 {
    public static void main(String[] args) {

        final Car car1 = Car.create(Car::new);
        car1.setName("Benz");
        final Car car2 = Car.create(Car::new);
        car2.setName("BMW");
        final List<Car> cars = Arrays.asList(car1, car2);

        cars.forEach(Car::collide);
//        for (Car car : cars) {
//            Car.collide(car);
//        }

        cars.forEach(Car::repair);
//        for (Car car : cars) {
//            car.repair();
//        }

        final Car police = Car.create(Car::new);
        police.setName("police-car");
        cars.forEach(police::follow);
//        for (Car car: cars) {
//            police.follow(car);
//        }


        List<String> names = new ArrayList<>();

        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");

        names.forEach(System.out::println);

    }
}
