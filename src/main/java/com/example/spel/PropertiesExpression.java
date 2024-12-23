package com.example.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class PropertiesExpression {

    public static void main(String[] args) {
        Inventor tesla = new Inventor("tesla", "China");
        tesla.setPlaceOfBirth(new PlaceOfBirth("shanghai", "China"));
        tesla.setInventions(new String[]{"hunan", "shanghai", "beijing"});

        Inventor ieee = new Inventor("ieee", "America");
        ieee.setPlaceOfBirth(new PlaceOfBirth("Nikola Tesla", "America"));
        ieee.setInventions(new String[]{"New York", "Nikola Tesla", "Los Angeles"});

        EvaluationContext context = new StandardEvaluationContext(tesla);

        SpelExpressionParser parser = new SpelExpressionParser(new SpelParserConfiguration(true, true));

        // -- 属性访问 第一个字母不区分大小写

        // 2024 使用EvaluationContext上下文
        System.out.println(parser.parseExpression("Birthdate.Year + 1900").getValue(context, Integer.class));

        // shanghai 使用EvaluationContext上下文
        System.out.println(parser.parseExpression("placeOfBirth.City").getValue(context, String.class));


        // -- 集合访问

        // beijing 使用目标对象 tesla
        System.out.println(parser.parseExpression("inventions[2]").getValue(
                context, tesla, String.class));

        // Los Angeles 指定对象 ieee
        System.out.println(parser.parseExpression("inventions[2]").getValue(
                context, ieee, String.class));

    }
}
