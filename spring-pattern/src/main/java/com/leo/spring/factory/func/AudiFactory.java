package com.leo.spring.factory.func;

import com.leo.spring.factory.Audi;
import com.leo.spring.factory.Car;

public class AudiFactory implements  Factory{
    @Override
    public Car getCar() {
        return new Audi();
    }
}
