package com.leo.spring.prototype.greatestsage;

public class TestPrototype {
	/**
	 * 1.反射效率并不高，一般用于初始化
	 * 2.浅复制 指的是值复制对象的第一层引用和默认的几种类型的值，而不是引用所指的对象，java默认支持8个基本类型和String
	 * 3.深度克隆，使用字节码操作，不需要构造器的
	 * @param args
	 */
	public static void main(String[] args) {
		TheGreatestSage sage = new TheGreatestSage();
		sage.change();
		
		//跟《西游记》中描述的一致，怎么办？
	}
}