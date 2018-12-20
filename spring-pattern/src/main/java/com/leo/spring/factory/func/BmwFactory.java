package com.leo.spring.factory.func;

import com.leo.spring.factory.Bmw;
import com.leo.spring.factory.Car;

public class BmwFactory implements Factory {
    @Override
    public Car getCar() {
        return new Bmw();
    }
}
