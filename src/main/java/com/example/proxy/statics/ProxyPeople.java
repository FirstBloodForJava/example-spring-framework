package com.example.proxy.statics;

import com.example.proxy.People;

/**
 * @author ouyangcm
 * create 2024/12/26 14:39
 */
public class ProxyPeople implements People {

    People target;

    public ProxyPeople(People target) {
        this.target = target;
    }

    @Override
    public void say(String msg) {
        System.out.println("Proxy start");

        if (msg.contains("草")) {
            target.say(msg.replaceAll(".", "*"));
        }else {
            target.say(msg);
        }

        System.out.println("Proxy end");

    }
}
