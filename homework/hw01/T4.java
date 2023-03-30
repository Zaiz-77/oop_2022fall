package com.oop.homework.hw01;

import java.util.*;

public class T4 {
    public static void main(String[] args) {
        T4 solve = new T4();
        Scanner in = new Scanner(System.in);
        String c = in.next();
        int n = in.nextInt();
        while (!c.equals("q")) {
            solve.print(c, n);
            c = in.next();
            n = in.nextInt();
        }
    }

    public void print(String s, int n) {
        switch (s) {
            case "a":
                printA(n);
                break;
            case "b":
                printB(n);
                break;
            case "c":
                printC(n);
                break;
            case "d":
                printD(n);
                break;
            case "e":
                printE(n);
                break;
        }
    }

    private void printA(int n) {
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                for (int c = 0; c < n; c++) System.out.print("#");
            } else {
                for (int j = 0; j < n; j++) {
                    if (j == 0 || j == n - 1) {
                        System.out.print("#");
                    } else System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private void printB(int n) {
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                for (int c = 0; c < n; c++) System.out.print("#");
            } else {
                for (int j = 0; j < n; j++) {
                    if (i - j == 0) {
                        System.out.print("#");
                    } else System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private void printC(int n) {
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                for (int c = 0; c < n; c++) System.out.print("#");
            } else {
                for (int j = 0; j < n; j++) {
                    if (i + j == n - 1) {
                        System.out.print("#");
                    } else System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private void printD(int n) {
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                for (int c = 0; c < n; c++) System.out.print("#");
            } else {
                for (int j = 0; j < n; j++) {
                    if (i + j == n - 1 || i - j == 0) {
                        System.out.print("#");
                    } else System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private void printE(int n) {
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                for (int c = 0; c < n; c++) System.out.print("#");
            } else {
                for (int j = 0; j < n; j++) {
                    if (j == 0 || j == n - 1 || i - j == 0 || i + j == n - 1) {
                        System.out.print("#");
                    } else System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
