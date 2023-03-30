package com.oop.review;

import java.util.*;

public class Student extends People {

    public Student() {
    }

    // 注意自己生成的构造器，实际上是通过父类构造的
    public Student(String name, int age) {
        super(name, age);
    }

    public boolean goOut() {
        return false;
    }
}
