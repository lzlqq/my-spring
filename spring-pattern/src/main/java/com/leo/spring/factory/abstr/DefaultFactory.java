package com.leo.spring.factory.abstr;

import com.leo.spring.factory.Car;

public class DefaultFactory extends AbstractFactory {

    private AudiFactory defaultFactory = new AudiFactory();

    @Override
    protected Car getCar() {
        return defaultFactory.getCar();
    }
}
