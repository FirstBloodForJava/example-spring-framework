package com.example.aop;

import com.example.service.RedisServiceInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationRun {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //RedisService redisService = context.getBean(RedisService.class);
        RedisServiceInterface redisService = context.getBean(RedisServiceInterface.class);
        System.out.println(redisService.getClass());
        System.out.println(redisService.get("key"));
    }
}
