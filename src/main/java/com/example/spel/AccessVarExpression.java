package com.example.spel;

import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ouyangcm
 * create 2024/12/24 13:19
 */
public class AccessVarExpression {

    public static void main(String[] args) {
        SpelExpressionParser parser = new SpelExpressionParser();

        School school = new School();
        school.setClassName("name");

        SimpleEvaluationContext context = SimpleEvaluationContext.forReadWriteDataBinding().withRootObject(school).build();

        // 设置变量
        context.setVariable("name", "new Name");

        System.out.println(school.getClassName());
        parser.parseExpression("className = #name").getValue(context);
        System.out.println(school.getClassName());

        List<Integer> list = Arrays.asList(1, 2, 3, 10, 12);
        context.setVariable("list", list);
        // 使用.?[] 集合过滤器 [] 中接判断条件
        // #this表示当前对象自己
        // #root表示context中的对象
        List<Integer> filterList = (List<Integer>) parser.parseExpression("#list.?[#this > 4 && #root.className == #name]").getValue(context);
        // [10, 12]
        System.out.println(filterList);
    }
}
