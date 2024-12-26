package com.example.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ouyangcm
 * create 2024/12/26 15:01
 */
public class DynamicProxyHandler implements InvocationHandler {

    private Object target;

    public DynamicProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("DynamicProxy start");

        if (args.length > 0) {
            if (String.valueOf(args[0]).contains("草")) {
                args[0] = args[0].toString().replaceAll(".", "*");
            }
        }

        Object result = method.invoke(target, args);
        System.out.println("DynamicProxy end");
        return result;
    }
}
