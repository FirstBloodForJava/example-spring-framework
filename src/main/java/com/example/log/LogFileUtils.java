package com.example.log;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LogFileUtils {


    public static Writer getWriter(String fileName) throws IOException {
        return new BufferedWriter(new FileWriter(fileName));
    }

    public static void writeString(String content, Writer writer) throws IOException {
        writer.write(content);
        writer.write("\n");
    }

    public static BufferedReader getBufferedReader(String filename) throws IOException {
        InputStream inputStream = Files.newInputStream(Paths.get(filename));

        return new BufferedReader(new InputStreamReader(inputStream));
    }

    public static List<String> getMatchFromFile(String filename, String match, String notMatch) throws IOException {
        BufferedReader reader = getBufferedReader(filename);

        List<String> result = new ArrayList<>();
        String line = null;
        while (true) {
            try {
                if ((( line = reader.readLine()) == null)) break;
                if (line.contains(match)) {
                    if (notMatch == null) {
                        result.add(line);
                    }else if (!line.contains(notMatch)) {
                        result.add(line);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        return result;
    }

    public static List<String> getStartEndFromFile(String filename, String start, String end, String unique) throws IOException, ParseException {

        BufferedReader reader = getBufferedReader(filename);

        String line = null;
        List<String> startList = new ArrayList<>();
        List<String> endList = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            if (line.contains(start)) {
                startList.add(line);
            }else if (line.contains(end)) {
                endList.add(line);
            }
        }

        return mergeStartEnd(startList, endList, unique);
    }

    public static List<String> mergeStartEnd(List<String> startList, List<String> endList, String unique) throws ParseException {
        List<String> list = new ArrayList<>();
        String format = "%s, %s, %s, %d";

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");

        int ii = 0;
        int flagIndex = -1;
        Map<String, Integer> endStartMap = new HashMap<>();

        Map<Long, Integer> counts = new HashMap<>();

        for (String startLine : startList) {
            String[] split = startLine.split(" ");

            if (flagIndex < 0) {
                for (int k = 0; k < split.length; k++) {
                    if (split[k] != null && split[k].contains(unique)) {
                        flagIndex = k;
                        break;
                    }
                }
            }

            String s1 = split[0];
            String uniqueKey = split[flagIndex];
            Integer integer = endStartMap.get(uniqueKey);
            if (integer != null) {
                ii = integer + 1;
            }else {
                ii = 0;
            }
            for (int j = ii; j < endList.size(); j++) {
                String endLine = endList.get(j);
                //String[] split1 = endLine.split(" ");

                if (endLine.contains(uniqueKey)) {
                    endStartMap.put(uniqueKey, j);

                    String s2 = endLine.substring(0, 12);

                    Date start = sdf.parse(s1);
                    Date end = sdf.parse(s2);
                    long timeDif = end.getTime() - start.getTime();

                    long key = timeDif / 100;
                    counts.merge(key, 1, Integer::sum);

                    list.add(String.format(format, s1, s2, uniqueKey, timeDif));
                    break;
                }
            }
        }
        // todo 记录批次
        for (Map.Entry<Long, Integer> keyValue : counts.entrySet()) {
            //System.out.println(keyValue);
        }
        return list;
    }

    public static List<LogEvent> getLogEventList(String filename, String start, String end, String unique) throws IOException, ParseException {

        BufferedReader reader = getBufferedReader(filename);

        String line = null;
        List<String> startList = new ArrayList<>();
        List<String> endList = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            if (line.contains(start)) {
                startList.add(line);
            }else if (line.contains(end)) {
                endList.add(line);
            }
        }

        return mergeStartEndToObj(startList, endList, unique);
    }


    public static List<LogEvent> mergeStartEndToObj(List<String> startList, List<String> endList, String unique) throws ParseException {
        List<LogEvent> list = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        int ii = 0;
        int flagIndex = -1;
        Map<String, Integer> endStartMap = new HashMap<>();

        Map<Long, Integer> counts = new HashMap<>();

        for (String startLine : startList) {
            String[] split = startLine.split(" ");

            if (flagIndex < 0) {
                for (int k = 0; k < split.length; k++) {
                    if (split[k] != null && split[k].contains(unique)) {
                        flagIndex = k;
                        break;
                    }
                }
            }

            String s1 = split[0] + " " + split[1];
            String uniqueKey = split[flagIndex];
            Integer integer = endStartMap.get(uniqueKey);
            if (integer != null) {
                ii = integer + 1;
            }else {
                ii = 0;
            }
            for (int j = ii; j < endList.size(); j++) {
                String endLine = endList.get(j);
                //String[] split1 = endLine.split(" ");

                if (endLine.contains(uniqueKey)) {
                    endStartMap.put(uniqueKey, j);

                    String s2 = endLine.substring(0, 23);

                    Date start = sdf.parse(s1);
                    Date end = sdf.parse(s2);
                    long timeDif = end.getTime() - start.getTime();

                    long key = timeDif / 100;
                    counts.merge(key, 1, Integer::sum);

                    list.add(new LogEvent(s1, s2, uniqueKey, timeDif, startLine.substring(startLine.indexOf("getHandler:420"))));
                    break;
                }
            }
        }
        // todo
        for (Map.Entry<Long, Integer> keyValue : counts.entrySet()) {
            //System.out.println(keyValue);
        }

        return list;
    }
}
