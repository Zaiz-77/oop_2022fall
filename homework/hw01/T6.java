package com.oop.homework.hw01;

import java.util.*;

public class T6 {
    public static void main(String[] args) {
        T6 solve = new T6();
        Random rand = new Random();
        int cnt = 0;
        for (int i = 0; i < 100000; i++) {
            double x = rand.nextDouble() * 4 - 2, y = rand.nextDouble() * 4 - 2;
            if (solve.check(x, y)) cnt++;
        }
        System.out.printf("%.3f%%", 1.0 * cnt / 1000);
    }

    public boolean check(double x, double y) {
        boolean ok1 = false, ok2 = false;
        if (x >= -2 && x <= 0 && y >= -2 && y <= 2) ok1 = true;
        if (x >= 0 && y >= 0 && x + y <= 2) ok2 = true;
        return ok1 || ok2;
    }
}
