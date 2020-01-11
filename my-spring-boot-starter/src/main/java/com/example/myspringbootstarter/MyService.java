package com.example.myspringbootstarter;


public class MyService {
    String prefix;
    String suffix;

    public MyService(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public String doService() {
        System.out.println("do service");
        return prefix + suffix;
    }
}
