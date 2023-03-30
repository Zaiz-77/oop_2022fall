package com.oop.review;

import java.util.*;

public class People {
    static String type = "people";
    private String name;
    private int age;

    public People() {}

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println(this.getName() + "吃米饭");
        String s1 = "a";
    }

    public void eat(String food) {
        System.out.println(this.getName() + "eat" + food);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
