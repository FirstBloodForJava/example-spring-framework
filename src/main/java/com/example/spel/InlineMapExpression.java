package com.example.spel;

import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import java.util.Map;

/**
 * @author ouyangcm
 * create 2024/12/23 15:51
 */
public class InlineMapExpression {

    public static void main(String[] args) {

        SpelExpressionParser parser = new SpelExpressionParser();

        SimpleEvaluationContext readContext = SimpleEvaluationContext.forReadOnlyDataBinding().build();

        Map m1 = (Map) parser.parseExpression("{name:'Nikola',dob:'10-July-1856', age: 10}").getValue(readContext);
        // 10
        System.out.println(m1.get("age"));

        Map mapOfMaps = (Map) parser.parseExpression("{name:{first:'Nikola',last:'Tesla'},dob:{day:10,month:'July',year:1856}}").getValue(readContext);

        // {day=10, month=July, year=1856}
        System.out.println(mapOfMaps.get("dob"));

        Map empty = (Map) parser.parseExpression("{:}").getValue(readContext);
        // true
        System.out.println(empty.isEmpty());
    }
}
