package com.oop.homework.hw01;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.*;

public class T3 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fi = new Scanner(new File("D:\\FakeC\\Java_Works\\assignment\\src\\com\\oop\\homework\\hw01\\zt3input.txt"));
        Scanner in = new Scanner(System.in);
        T3 solve = new T3();
        StringBuilder now = new StringBuilder();

        while (fi.hasNext()) now.append(fi.next());
        int n = in.nextInt();

        while (n < 1 || n > now.length() - 1) {
            System.out.println("Input invalid!");
            n = in.nextInt();
        }
        System.out.println(solve.getMaxProduct(now.toString(), n));
    }

    /**
     * Get the max product by brute-force
     *
     * @param s the number
     * @param n the size of slide window
     * @return the max product
     */
    public BigInteger getMaxProduct(String s, int n) {
        BigInteger res = BigInteger.ZERO;
        for (int i = 0; i + n < s.length(); i++) {
            BigInteger now = BigInteger.ONE;
            for (int j = i; j < i + n; j++) now = now.multiply(new BigInteger(String.valueOf(s.charAt(j))));
            if (now.compareTo(res) > 0) res = now;
        }
        return res;
    }
}
