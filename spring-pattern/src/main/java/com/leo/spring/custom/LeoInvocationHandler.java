package com.leo.spring.custom;

import java.lang.reflect.Method;

public interface LeoInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
