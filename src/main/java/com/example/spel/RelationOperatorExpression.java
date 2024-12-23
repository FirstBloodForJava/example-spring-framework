package com.example.spel;

import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author ouyangcm
 * create 2024/12/23 16:30
 */
public class RelationOperatorExpression {

    public static void main(String[] args) {
        SpelExpressionParser parser = new SpelExpressionParser();

        // -- 关系运算符

        System.out.println(parser.parseExpression("'a' == 'b'").getValue(Boolean.class));
        System.out.println(parser.parseExpression("'a' != 'b'").getValue(Boolean.class));

        System.out.println(parser.parseExpression("'a' >= 'b'").getValue(Boolean.class));
        // false
        System.out.println(parser.parseExpression(" 0 > null").getValue(Boolean.class));

        System.out.println(parser.parseExpression("'xyz' instanceof T(Integer)").getValue(Boolean.class));
        System.out.println(parser.parseExpression("1 instanceof T(Integer)").getValue(Boolean.class));

        // false 基本数据类型的结果为false
        System.out.println(parser.parseExpression("1 instanceof T(int)").getValue(Boolean.class));
        // true
        System.out.println(parser.parseExpression("'5.00' matches '^-?\\d+(\\.\\d{2})?$'").getValue(Boolean.class));

        // false 小数点2位
        System.out.println(parser.parseExpression("'5.0067' matches '^-?\\d+(\\.\\d{2})?$'").getValue(Boolean.class));

    }
}
