package com.leo.spring.factory.func;

public class FactoryTest {
    /**
     * 工厂方法模式
     * 用户获取Bean的时候还要知道工厂的信息，使用起来的不好，耦合性太高了，用户只关心产品
     * @param args
     */
    public static void main(String[] args) {

        //工厂方法模式
        //各个产品的生产商，都拥有各自的工厂
        //生产工艺，生成的高科技程度都是不一样的
        Factory factory = new AudiFactory();
        System.out.println(factory.getCar());

        //需要用户关心，这个产品的生产商
        factory = new BmwFactory();
        System.out.println(factory.getCar());

        //增加的代码的使用复杂度


        //抽象工厂模式

    }

}