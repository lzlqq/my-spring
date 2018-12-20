package com.leo.spring.factory.abstr;

public class AbstractFactoryTest {
    /**
     * 抽象工厂模式
     * 这里得defaultFactory 的用处不是真的只是要用它自己的getCar，那个默认的给audi的
     * 而是有了它，就可以实例化了，使用的时候是用父类的getCar（String name）这个神奇的方法
     * 用户无感知的获得产品，只需要一个需求即可，耦合性极低
     */
    public static void main(String[] args) {

        DefaultFactory factory = new DefaultFactory();

        System.out.println(factory.getCar("Benz"));

        //设计模式的经典之处，就在于，解决了编写代码的人和调用代码的人双方的痛处
        //解放我们的双手

    }
}
