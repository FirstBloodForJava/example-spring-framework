package com.example.spel;

import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ouyangcm
 * create 2024/12/23 17:07
 */
public class AssignmentOperatorExpression {

    public static void main(String[] args) {

        Teacher teacher = new Teacher("shanghai", "China");

        SpelExpressionParser parser = new SpelExpressionParser();

        SimpleEvaluationContext context = SimpleEvaluationContext.forReadWriteDataBinding().build();

        parser.parseExpression("city").setValue(context, teacher,"beijing");
        System.out.println(teacher.getCity());

        System.out.println(parser.parseExpression("City = 'shanghai'").getValue(context, teacher, String.class));
        System.out.println(teacher.getCity());

    }
}
