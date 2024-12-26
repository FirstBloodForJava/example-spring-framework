package com.example.proxy.cglib;


import net.sf.cglib.proxy.Enhancer;

/**
 * @author ouyangcm
 * create 2024/12/26 15:39
 */
public class CglibProxyDemo {

    public static void main(String[] args) {
        // 创建 CGLIB Enhancer
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(AmericanPeople.class);
        enhancer.setCallback(new CglibProxyHandler());

        // 生成代理对象
        AmericanPeople proxy = (AmericanPeople) enhancer.create();

        // 调用代理方法
        proxy.say("hello world");
    }
}
