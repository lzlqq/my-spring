package com.leo.spring.factory.func;

import com.leo.spring.factory.Benz;
import com.leo.spring.factory.Car;

public class BenzFactory implements Factory {
    @Override
    public Car getCar() {
        return new Benz();
    }
}
