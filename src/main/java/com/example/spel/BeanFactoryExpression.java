package com.example.spel;

import org.springframework.expression.AccessException;
import org.springframework.expression.BeanResolver;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.SpelEvaluationException;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ouyangcm
 * create 2024/12/24 14:10
 */
public class BeanFactoryExpression {

    public static void main(String[] args) {

        final Map<String, Class<?>> map = new HashMap<>();
        map.put("String", String.class);
        map.put("&Integer", Integer.class);

        StandardEvaluationContext context = new StandardEvaluationContext();
        // 自定义bean解析器
        context.setBeanResolver(new BeanResolver() {
            @Override
            public Object resolve(EvaluationContext context, String beanName) throws AccessException {
                // 这里的名称是 去掉@的字符串
                if (map.containsKey(beanName)) {
                    return map.get(beanName);
                }
                throw new AccessException("map not contain object, name = " + beanName);
            }
        });

        SpelExpressionParser parser = new SpelExpressionParser();
        // class java.lang.String 访问的beanName = String
        System.out.println(parser.parseExpression("@String").getValue(context, Class.class));
        // class java.lang.String 访问的beanName = &Integer
        System.out.println(parser.parseExpression("&Integer").getValue(context, Class.class));


    }
}


