package com.oop.homework.hw02;

import java.util.*;

public class TestIncrement {
    public static void main(String[] args) {
        MyTime t1 = new MyTime(23, 59, 59);
        System.out.println("test second increment");
        System.out.println("before");
        System.out.println(t1.toUniversalString());
        System.out.println(t1.toString());
        t1.incrementSecond();
        System.out.println("after");
        System.out.println(t1.toUniversalString());
        System.out.println(t1.toString());
        System.out.println();

        MyTime t2 = new MyTime(15, 59, 23);
        System.out.println("test minute increment");
        System.out.println("before");
        System.out.println(t2.toUniversalString());
        System.out.println(t2.toString());
        t2.incrementMinute();
        System.out.println("after");
        System.out.println(t2.toUniversalString());
        System.out.println(t2.toString());
        System.out.println();

        MyTime t3 = new MyTime(23, 19, 43);
        System.out.println("test hour increment");
        System.out.println("before");
        System.out.println(t3.toUniversalString());
        System.out.println(t3.toString());
        t3.incrementHour();
        System.out.println("after");
        System.out.println(t3.toUniversalString());
        System.out.println(t3.toString());
        System.out.println();
    }
}
