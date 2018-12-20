package com.leo.spring.proxy.custom;

import com.leo.spring.proxy.jdk.Person;

import java.lang.reflect.Method;

public class LeoMeipo implements LeoInvocationHandler {

    private Person target;

    public Object getInstance(Person target){
        this.target=target;
        Class clazz = target.getClass();
        return LeoProxy.newProxyInstance(new LeoClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是媒婆：得给你找个异性才行");
        System.out.println("开始进行海选...");
        System.out.println("------------");
        method.invoke(this.target, args);
        System.out.println("------------");
        System.out.println("如果合适的话，就准备办事");
        return null;
    }
}
