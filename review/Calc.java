package com.oop.review;

import java.util.Scanner;

public class Calc {

    private void check(int x) throws MyException {
        if (x == 0) {
            throw new MyException("0 cannot be divided!");
        }
    }

    public void divide(int a, int b) {
        try {
            check(b);
            System.out.println(a / b);
        } catch (MyException e) {
            e.printStackTrace();
        } finally {
            System.out.println("done!");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(), b = in.nextInt();
        int res;
        try {
            if (b == 0) throw new MyException("bad!");
            res = a / b;
            System.out.println(res);
        } catch (MyException e) {
            e.printStackTrace();
        } finally {
            System.out.println("whatever");
        }
    }
}
