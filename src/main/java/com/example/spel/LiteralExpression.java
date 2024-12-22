package com.example.spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class LiteralExpression {

    public static void main(String[] args) {

        ExpressionParser parser = new SpelExpressionParser();

        // Hello World
        String helloWorld = (String) parser.parseExpression("'Hello World'").getValue();

        // 6.0221415E23
        double avogadrosNumber = (Double) parser.parseExpression("6.0221415E+23").getValue();

        // 2147483647
        int maxValue = (Integer) parser.parseExpression("0x7FFFFFFF").getValue();

        //
        boolean trueValue = (Boolean) parser.parseExpression("true").getValue();

        // null对象
        Object nullValue = parser.parseExpression("null").getValue();
    }
}
