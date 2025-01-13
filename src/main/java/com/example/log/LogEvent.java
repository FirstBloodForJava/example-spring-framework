package com.example.log;

public class LogEvent {

    public String startStr;
    public String endStr;
    public String unique;
    public long dif;
    public String endFlag;
    public String group;

    public LogEvent(String startStr, String endStr, String unique, long dif, String group) {
        this.startStr = startStr;
        this.endStr = endStr;
        this.unique = unique;
        this.dif = dif;
        this.group = group;
    }
}
