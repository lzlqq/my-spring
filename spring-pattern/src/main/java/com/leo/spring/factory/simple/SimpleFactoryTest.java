package com.leo.spring.factory.simple;

import com.leo.spring.factory.Car;

public class SimpleFactoryTest {


    public static void main(String[] args) {

        //这边就是我们的消费者
        Car car = new SimpleFactory().getCar("Audi");
        System.out.println(car.getName());

    }

}