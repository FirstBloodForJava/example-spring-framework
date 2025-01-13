package com.example.log;

import java.io.IOException;
import java.io.Writer;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) throws IOException, ParseException {

        List<String> startList = LogFileUtils.getStartEndFromFile("portal.log", "oss请求参数", "oss请求返回结果", "task");
        Writer w1 = LogFileUtils.getWriter("analysis.txt");
        for (String s : startList) {
            LogFileUtils.writeString(s, w1);
        }
        w1.flush();

        List<LogEvent> endList = LogFileUtils.getLogEventList("oss.log", "XmlComponentController.componentAnalysis(com", "AfterReturningResult", "task");
        String format = "%s, %s, %s, %d";
        List<String> list= new ArrayList<>();
        for (LogEvent logEvent : endList) {
            list.add(String.format(format, logEvent.startStr.split(" ")[1], logEvent.endStr.split(" ")[1], logEvent.unique, logEvent.dif));
        }
        Writer w2 = LogFileUtils.getWriter("oss-analysis.txt");
        for (String s : list) {
            LogFileUtils.writeString(s, w2);
        }
        w2.flush();

        long beforeCount = 0L;
        for (String s : startList) {
            beforeCount += Long.parseLong(s.substring(s.lastIndexOf(",") + 1).trim());
        }
        System.out.println(beforeCount);
        System.out.println(beforeCount / startList.size());

        long afterCount = 0L;
        for (String s : list) {
            afterCount += Long.parseLong(s.substring(s.lastIndexOf(",") + 1).trim());
        }
        System.out.println(afterCount);
        System.out.println(afterCount / list.size());

    }
}
