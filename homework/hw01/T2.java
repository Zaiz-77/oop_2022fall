package com.oop.homework.hw01;

import java.util.*;

public class T2 {
    /**
     * Preparations
     */
    String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    String[] ten = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    String[] tens = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        T2 solve = new T2();
        int now = in.nextInt();
        while (!solve.valid(now)) {
            System.out.println("Input invalid!");
            now = in.nextInt();
        }
        System.out.println(solve.getEnglish(now));
    }

    /**
     * Check the number is valid or not
     *
     * @param n the number
     * @return valid true else false
     */
    public boolean valid(int n) {
        return n >= -999999999 && n <= 999999999;
    }

    /**
     * Get the English expression of the number
     *
     * @param n the number
     * @return the English string
     */
    public String getEnglish(int n) {
        return n >= 0 ? work(n) : "negative " + work(-n);
    }

    /**
     * Main process function to convert the number to its English expression
     *
     * @param n the number given
     * @return Its English expression
     */
    private String work(int n) {
        if (n == 0) return "zero";
        if (n >= 1 && n <= 9) return digits[n];

        char[] now = String.valueOf(n).toCharArray();
        char[] a = new char[9];
        Arrays.fill(a, '0');
        System.arraycopy(now, 0, a, 9 - now.length, now.length);

        String million = get(a, 0), thousand = get(a, 3), hundred = get(a, 6);

        million = million.equals("") ? million : million + " million";
        if (thousand.equals("")) {
            if (million.equals("")) thousand = "";
            else if (!hundred.equals("")) thousand = " zero";
        } else thousand += " thousand";
        return (million + thousand + hundred).substring(1);
    }

    /**
     * Get the English expression of a three-bit number
     *
     * @param a  array
     * @param st the start of the number
     * @return its English expression
     */
    private String get(char[] a, int st) {
        int a1 = a[st] - '0', a2 = a[st + 1] - '0', a3 = a[st + 2] - '0';
        if (a1 == 0 && a2 == 0 && a3 == 0) return "";
        if (a1 == 0 && a2 == 0) return String.format(" %s", digits[a3]);

        StringBuilder res = new StringBuilder();
        if (a1 != 0) res.append(String.format(" %s hundred", digits[a1]));
        if (a2 == 0 && a3 == 0) return res.toString();

        if (a2 == 0) {
            res.append(String.format(" zero %s", digits[a3]));
            return res.toString();
        }

        if (a2 == 1) {
            res.append(String.format(" %s", ten[a3]));
            return res.toString();
        }

        res.append(String.format(" %s", tens[a2 - 2]));
        if (a3 == 0) return res.toString();
        res.append(String.format(" %s", digits[a3]));
        return res.toString();
    }
}
