package com.leo.spring.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Meipo implements InvocationHandler {
    //被代理对象的引用作为一个成员变量保存下来了
    private Person target;
    //获取被代理人的个人资料
    public Object getInstance(Person target){
        this.target=target;
        Class clazz =target.getClass();
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是媒婆：" + "得给你找个异性才行");
        System.out.println("开始进行海选...");
        System.out.println("------------");
        method.invoke(this.target,args);//调用的时候
        System.out.println("------------");
        System.out.println("如果合适的话，就准备办事");
        return null;
    }
}
