package com.oop.review;

import java.util.*;

public class StringTest {
    public static void main(String[] args) {
        String s1 = new String("hello");
        String s2 = "hello";
        String s3 = "hello";
        String s4 = new String(s2);
        System.out.println(s1 == s2); // false
        System.out.println(s2 == s3); // true
        System.out.println(s1 == s3); // false
        System.out.println(s2 == s4); // false
    }
}
