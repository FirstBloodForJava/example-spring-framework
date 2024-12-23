package com.example.spel;

import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author ouyangcm
 * create 2024/12/23 16:52
 */
public class LogicalOperationExpression {

    public static void main(String[] args) {
        SpelExpressionParser parser = new SpelExpressionParser();

        LogicalOperationExpression object = new LogicalOperationExpression();

        StandardEvaluationContext context = new StandardEvaluationContext(object);


        System.out.println(parser.parseExpression("true and false").getValue(Boolean.class));
        System.out.println(parser.parseExpression("false and isTrue('true')").getValue(Boolean.class));

        System.out.println(parser.parseExpression("true or isTrue('false')").getValue(context, Boolean.class));
        System.out.println(parser.parseExpression("!false or isTrue('false')").getValue(context, Boolean.class));



    }

    public boolean isTrue(String flag) {
        System.out.println("LogicalOperationExpression isTrue: " + flag);
        return "true".equals(flag);
    }
}
