package com.oop.homework.hw01;

import java.util.*;

public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        T1 solve = new T1();
        String upc = in.next();
        while (!solve.valid(upc)) {
            System.out.println("Input invalid!");
            upc = in.next();
        }
        upc = solve.process(upc);
        System.out.println(upc + solve.getUPC(upc));
    }

    /**
     * Check whether this string consists only of numbers
     *
     * @param s the string
     * @return true if it is else false
     */
    public boolean valid(String s) {
        int n = s.length();
        if (n > 11) return false;
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    /**
     * Assuming that the string meets the requirements of the type but the length is less than eleven bits, we need to preprocess it.
     *
     * @param s the string
     * @return the string processed
     */
    public String process(String s) {
        StringBuilder res = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < 11 - n; i++) res.append("0");
        res.append(s);
        return res.toString();
    }

    /**
     * Get the UPC code from a string
     *
     * @param upc the string to be solved
     * @return the UPC code
     */
    public int getUPC(String upc) {
        int odd = 0, even = 0;
        for (int i = 0; i < upc.length(); i++) {
            if (((i + 1) & 1) == 1) even += upc.charAt(i) - '0';
            else odd += upc.charAt(i) - '0';
        }
        int all = 3 * even + odd;
        return 10 - all % 10;
    }
}
