package com.oop.review;

import java.util.Arrays;

public class Main {

    static int square(int x) {
        return x * x;
    }

    static void say() {
        System.out.println("good morning!");
    }

    public static void main(String[] args) {
        System.out.println("基本数据类型：");
        System.out.println("Byte:" + Byte.SIZE + " " + Byte.MIN_VALUE + " " + Byte.MAX_VALUE);
        System.out.println("Int:" + Integer.SIZE + " " + Integer.MIN_VALUE + " " + Integer.MAX_VALUE);
        System.out.println("Short:" + Short.SIZE + " " + Short.MIN_VALUE + " " + Short.MAX_VALUE);
        System.out.println("Long:" + Long.SIZE + " " + Long.MIN_VALUE + " " + Long.MAX_VALUE);
        System.out.println("Float:" + Float.SIZE + " " + Float.MIN_VALUE + " " + Float.MAX_VALUE);
        System.out.println("Double:" + Double.SIZE + " " + Double.MIN_VALUE + " " + Double.MAX_VALUE);
        System.out.println("Char:" + Character.SIZE + " " + Character.MIN_VALUE + " " + Character.MAX_VALUE);
        System.out.println("Boolean:" + Boolean.TRUE + " " + Boolean.FALSE);
        System.out.println("类型转换:");
        System.out.println((byte) 130);

        System.out.println("给for循环命名:");
        outer:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < i; j++) {
                if (j == 3) break outer;
                System.out.println(i + " " + j);
            }
        }

        System.out.println("函数:");
        for (int i = 0; i < 5; i++) {
            System.out.println(square(i));
        }
        say();

        System.out.println("数组:");
        int[] a = new int[5];
        int[] b = {1, 2, 3, 4, 5};
        int[] c = b;
        int[] d = a;
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
        System.out.println(Arrays.toString(d));

        System.out.println("字符串:");
        char[] cs = {'a', 'p', 'p', 'l', 'e'};
        String s10 = new String(cs, 1, 3);
        System.out.println(s10);
        String s1 = "abc";
        String s2 = new String(s1);
        System.out.println(s1 == s2);

        System.out.println("可变字符串:");
        String s3 = "apple";
        String s4 = s3;
        System.out.println(s3 == s4);
        StringBuilder sb1 = new StringBuilder("apple");
        StringBuilder sb2 = new StringBuilder(s3);
        StringBuilder sb3 = new StringBuilder(s4);
        StringBuilder sb4 = new StringBuilder(sb1);

        System.out.println(sb1 == sb2);
        System.out.println(sb2 == sb3);
        System.out.println(sb1 == sb3);
        System.out.println(sb1 == sb4);

        System.out.println("标识符:");
        System.out.println("唯二可行的符号就是$和_");

        System.out.println("优先级:");
        int i = 5;
        System.out.println(3 * ++i);
        System.out.println(8|9&10^11);

        int ii = 1;
        double dd = 1.0;
        System.out.println(ii == dd);

        System.out.println("封装类:");
        Integer i1 = 159; // -128 - 127之间是true,new出来的都是false
        Integer i2 = 159;
        System.out.println(i1 == i2);
    }
}
