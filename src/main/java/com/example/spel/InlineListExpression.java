package com.example.spel;

import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import java.util.List;

/**
 * @author ouyangcm
 * create 2024/12/23 15:42
 */
public class InlineListExpression {

    public static void main(String[] args) {

        SpelExpressionParser parser = new SpelExpressionParser();

        SimpleEvaluationContext readContext = SimpleEvaluationContext.forReadOnlyDataBinding().build();

        List numberList = (List) parser.parseExpression("{0, 1, 2, 3, 4}").getValue(readContext);
        // 2
        System.out.println(numberList.get(2));

        List listList = (List) parser.parseExpression("{{'a', 'b'}, {'c', 'd', 'e'}}").getValue(readContext);
        // [a, b]
        System.out.println(listList.get(0));
    }
}
