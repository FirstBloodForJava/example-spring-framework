package com.example.spel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class School {

    private String className;

    private List<ClassInfo> members = new ArrayList();
    private Map officers = new HashMap();

    public List<ClassInfo> getMembers() {
        return members;
    }

    public void setMember(ClassInfo member) {
        members.add(member);
    }

    public void setMembers(List<ClassInfo> members) {
        members.addAll(members);
    }

    public Map getOfficers() {
        return officers;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public boolean isMember(String className) {
        for (ClassInfo aClassInfo : members) {
            if (aClassInfo.getName().equals(className)) {
                return true;
            }
        }
        return false;
    }
}
