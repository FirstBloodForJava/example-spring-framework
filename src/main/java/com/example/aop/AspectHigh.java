package com.example.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-1)
public class AspectHigh {

    /**
     * Before 前置Advice
     * @param thisObject 代理后的对象
     */
    @Before(value = "execution(* com.example.service.RedisService.get(..)) " +
            "&& this(thisObject) && target(targetObject)",
        argNames = "thisObject, targetObject"
    )
    public void before(Object thisObject, Object targetObject) {
        System.out.println("before AspectHigh exe");

    }

    @AfterReturning(value = "execution(* com.example.service.RedisService.get(..))" ,
            returning = "result"
    )
    public void afterReturning(String result) {
        System.out.println("afterReturning High " + result);
    }
}
