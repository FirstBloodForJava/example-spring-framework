package com.example.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.List;

public class Demo {

    public List<String> list;

    public static void main(String[] args) {
        // 1 true null属性自动创建
        // 2 true 数组自动扩容
        SpelParserConfiguration config = new SpelParserConfiguration(true,true);

        // 使用这个配置
        ExpressionParser parser = new SpelExpressionParser(config);

        Expression expression = parser.parseExpression("list[0]");

        Demo demo = new Demo();

        Object o = expression.getValue(demo);

        System.out.println(o);
    }
}
