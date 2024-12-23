package com.example.spel;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class ClassInfo {

    private String name;
    private String addr;
    private String[] students;
    private Date birthdate;
    private List<Teacher> teachers;

    public ClassInfo(String name, String addr) {
        GregorianCalendar c= new GregorianCalendar();
        this.name = name;
        this.addr = addr;
        this.birthdate = c.getTime();
    }

    public ClassInfo(String name, String addr, String[] students) {
        this.name = name;
        this.addr = addr;
        this.students = students;
    }

    public ClassInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setTeachers(Teacher teacher) {
        if (this.teachers == null) {
            this.teachers = new ArrayList<>();
        }
        this.teachers.add(teacher);

    }

    public List<Teacher> getTeachers() {
        return this.teachers;
    }

    public void setStudents(String[] students) {
        this.students = students;
    }

    public String[] getStudents() {
        return students;
    }
}
