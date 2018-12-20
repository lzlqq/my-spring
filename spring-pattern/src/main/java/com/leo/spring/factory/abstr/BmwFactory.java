package com.leo.spring.factory.abstr;

import com.leo.spring.factory.Bmw;
import com.leo.spring.factory.Car;

public class BmwFactory extends AbstractFactory {

	@Override
	public Car getCar() {
		return new Bmw();
	}

}
