package com.oop.review;

import java.util.*;

public class SwitchIf {
    public static void main(String[] args) {
        long st1 = System.nanoTime();
        for (int i = 0; i < 5; i++) {
            if (i == 3) System.out.println(3);
            if (i == 4) System.out.println(4);
        }
        long ed1 = System.nanoTime();
        System.out.println(ed1 - st1);

        long st2 = System.nanoTime();
        for (int i = 0; i < 5; i++) {
            switch (i) {
                case 3:
                    System.out.println(3);
                    break;
                case 4:
                    System.out.println(4);
                    break;
            }
        }
        long ed2 = System.nanoTime();
        System.out.println(ed2 - st2);

    }
}

