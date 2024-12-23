package com.example.spel;

public class Teacher {

    private String city;
    private String country;

    public Teacher(String city) {
        this.city=city;
    }

    public Teacher(String city, String country) {
        this(city);
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String s) {
        this.city = s;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
