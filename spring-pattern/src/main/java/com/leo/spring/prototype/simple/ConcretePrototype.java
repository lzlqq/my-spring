package com.leo.spring.prototype.simple;

import java.util.ArrayList;
import java.util.List;

public class ConcretePrototype implements  Cloneable {

    private  int age;
    private String name;

    public ArrayList<String> list = new ArrayList<>();

    protected  Object clone(){
        ConcretePrototype prototype =null;
        try{
            prototype = (ConcretePrototype) super.clone();
            //可以自己觉定要clone到第几层
            prototype.list= (ArrayList<String>) list.clone();

            //克隆基于字节码的
            //用反射，或者循环
        }catch (Exception e){

        }

        return  prototype;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
