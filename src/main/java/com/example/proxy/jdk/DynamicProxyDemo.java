package com.example.proxy.jdk;

import com.example.proxy.ChinesePeople;
import com.example.proxy.People;

import java.lang.reflect.Proxy;

/**
 * @author ouyangcm
 * create 2024/12/26 15:14
 */
public class DynamicProxyDemo {

    public static void main(String[] args) {

        People people = new ChinesePeople();

        DynamicProxyHandler proxyHandler = new DynamicProxyHandler(people);
        People proxyPeople = (People) Proxy.newProxyInstance(people.getClass().getClassLoader(),
                people.getClass().getInterfaces(),
                proxyHandler);

        proxyPeople.say("草, 无语死了");
    }
}
