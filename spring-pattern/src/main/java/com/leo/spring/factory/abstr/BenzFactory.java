package com.leo.spring.factory.abstr;

import com.leo.spring.factory.Benz;
import com.leo.spring.factory.Car;

public class BenzFactory extends AbstractFactory {

	@Override
	public Car getCar() {
		return new Benz();
	}

}