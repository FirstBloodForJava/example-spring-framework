package com.example.aop;

import com.example.event.CustomApplicationListener;
import com.example.service.RedisService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration(proxyBeanMethods = false)
@EnableAspectJAutoProxy
@ComponentScan("com.example.aop")
public class AppConfig {

    @Value("#{systemProperties['user.dir']}")
    private String pwd;

    @Bean
    RedisService redisService() {
        return new RedisService();
    }

    @Bean
    CustomApplicationListener customApplicationListener() {
        CustomApplicationListener applicationListener = new CustomApplicationListener();
        applicationListener.setPwd(pwd);
        return applicationListener;
    }
}
