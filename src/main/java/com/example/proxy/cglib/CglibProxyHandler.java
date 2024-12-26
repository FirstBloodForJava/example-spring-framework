package com.example.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author ouyangcm
 * create 2024/12/26 15:36
 */
public class CglibProxyHandler implements MethodInterceptor {

    private Object target;
    public CglibProxyHandler (Object target) {
        this.target = target;
    }

    public CglibProxyHandler(){}

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        System.out.println("cglib proxy: start");

        // 注意 如果方法是invoke,则obj应该为自己创建的对象
        Object result = methodProxy.invokeSuper(obj, args);

        System.out.println("cglib proxy: end");

        return result;
    }
}
