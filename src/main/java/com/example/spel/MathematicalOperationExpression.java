package com.example.spel;

import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author ouyangcm
 * create 2024/12/23 17:01
 */
public class MathematicalOperationExpression {

    public static void main(String[] args) {
        SpelExpressionParser parser = new SpelExpressionParser();


        System.out.println(parser.parseExpression("1 + 1").getValue(Integer.class));

        System.out.println(parser.parseExpression("'test' + ' ' + 'string'").getValue(String.class));

        System.out.println(parser.parseExpression("1 * 10").getValue(Integer.class));
    }
}
