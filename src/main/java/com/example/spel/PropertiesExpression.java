package com.example.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Date;
import java.util.Map;

public class PropertiesExpression {

    /**
     * 访问 对象的属性、数组、集合、map中的属性
     * @param args
     */
    public static void main(String[] args) {

        // 数据准备
        ClassInfo tesla = new ClassInfo("tesla", "shanghai", new Date(), new String[] {"Su7", "Su7 Pro Max", "Su7 Ultra"});
        Teacher t1 = new Teacher("China", "shanghai1");
        Teacher t2 = new Teacher("China", "shanghai2");
        tesla.setTeachers(t1);
        tesla.setTeachers(t2);

        ClassInfo xiaomi = new ClassInfo("xiaomi", "beijing", new Date(), new String[] {"Model X", "Model Y", "Model 3", "Model S"});
        Teacher x1 = new Teacher("China", "beijing1");
        Teacher x2 = new Teacher("China", "beijing2");
        xiaomi.setTeachers(x1);
        xiaomi.setTeachers(x2);

        School school = new School();
        school.setClassName("xiaomi");
        school.setMember(tesla);
        school.setMember(xiaomi);

        Map officers = school.getOfficers();
        officers.put("xiaomi", xiaomi);

        // 创建一个只读的context
        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();

        SpelExpressionParser parser = new SpelExpressionParser();

        // -- 属性访问 第一个字母不区分大小写

        // 2024
        System.out.println(parser.parseExpression("Birthdate.Year + 1900").getValue(tesla, Integer.class));

        // beijing
        System.out.println(parser.parseExpression("addr").getValue(xiaomi, String.class));


        // -- 访问集合元素

        // Su7 Ultra
        System.out.println(parser.parseExpression("students[2]").getValue(
                context, tesla, String.class));

        // Model 3
        System.out.println(parser.parseExpression("students[2]").getValue(
                context, xiaomi, String.class));

        // China
        System.out.println(parser.parseExpression("teachers[0].city").getValue(context, tesla, String.class));
        // beijing2
        System.out.println(parser.parseExpression("teachers[1].country").getValue(context, xiaomi, String.class));

        // -- 访问map元素 com.example.spel.ClassInfo
        System.out.println(parser.parseExpression("officers['xiaomi']").getValue(context, school, ClassInfo.class));

        // beijing1
        System.out.println(parser.parseExpression("officers['xiaomi'].teachers[0].country").getValue(context, school, String.class));


    }
}
