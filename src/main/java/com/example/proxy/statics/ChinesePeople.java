package com.example.proxy.statics;

/**
 * @author ouyangcm
 * create 2024/12/26 14:29
 */
public class ChinesePeople implements People{

    @Override
    public void say(String msg) {
        System.out.println(msg);
    }

}
