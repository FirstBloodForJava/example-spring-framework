package com.example.spel;

import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author ouyangcm
 * create 2024/12/24 11:27
 */
public class ConstructorExpression {

    public static void main(String[] args) {

        SpelExpressionParser parser = new SpelExpressionParser();

        ClassInfo xiaomi = parser.parseExpression("new com.example.spel.ClassInfo('xiaomi', 'beijing')").getValue(ClassInfo.class);

        System.out.println(xiaomi.getName());

        School school = new School();
        parser.parseExpression("Members.add(new com.example.spel.ClassInfo('xiaomi', 'beijing'))").getValue(school);
        System.out.println(school.getMembers().size());
    }
}
