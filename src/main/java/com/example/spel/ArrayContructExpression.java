package com.example.spel;

import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

/**
 * @author ouyangcm
 * create 2024/12/23 15:58
 */
public class ArrayContructExpression {

    public static void main(String[] args) {

        SpelExpressionParser parser = new SpelExpressionParser();

        SimpleEvaluationContext readContext = SimpleEvaluationContext.forReadOnlyDataBinding().build();

        int[] numbers1 = (int[]) parser.parseExpression("new int[4]").getValue(readContext);
        // 0
        System.out.println(numbers1[3]);

        int[] numbers2 = (int[]) parser.parseExpression("new int[]{1,2,3}").getValue(readContext);
        // 3
        System.out.println(numbers2[2]);

        int[][] numbers3 = (int[][]) parser.parseExpression("new int[4][5]").getValue(readContext);
        // 0
        System.out.println(numbers3[3][4]);

    }
}
