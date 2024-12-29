package com.example.proxy;

/**
 * @author ouyangcm
 * create 2024/12/26 14:29
 */
public class ChinesePeople implements People {

    {
        System.out.println("实例代码块");
    }
    public ChinesePeople() {
        System.out.println("ChinesePeople 无参构造执行");
    }
    @Override
    public void say(String msg) {
        System.out.println(msg);
    }

}
