package com.example.spel;

import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

/**
 * @author ouyangcm
 * create 2024/12/24 14:37
 */
public class TernaryOperatorExpression {

    public static void main(String[] args) {

        SpelExpressionParser parser = new SpelExpressionParser();

        System.out.println(parser.parseExpression("true ? 'true' : 'false'").getValue(String.class));

        SimpleEvaluationContext context = SimpleEvaluationContext.forReadWriteDataBinding().build();

        // null
        System.out.println(parser.parseExpression("#name != null ? #name : 'null'").getValue(context, String.class));
        context.setVariable("name", "name");
        // 三目运算符
        System.out.println(parser.parseExpression("#name != null ? #name : 'null'").getValue(context, String.class));
        // 简单的三目运算符
        System.out.println(parser.parseExpression("#name?:'null'").getValue(context, String.class));
    }
}
