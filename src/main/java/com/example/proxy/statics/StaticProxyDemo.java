package com.example.proxy.statics;

/**
 * @author ouyangcm
 * create 2024/12/26 14:44
 */
public class StaticProxyDemo {

    public static void main(String[] args) {

        People target = new ChinesePeople();

        ProxyPeople proxy = new ProxyPeople(target);

        proxy.say("草, 无语死了");

    }
}
