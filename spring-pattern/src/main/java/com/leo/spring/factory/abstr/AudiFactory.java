package com.leo.spring.factory.abstr;

import com.leo.spring.factory.Audi;
import com.leo.spring.factory.Car;

//具体的业务逻辑封装
public class AudiFactory extends AbstractFactory {
    @Override
    protected Car getCar() {
        return new Audi();
    }
}
