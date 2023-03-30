package com.oop.homework.hw01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class T5 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("D:\\FakeC\\Java_Works\\assignment\\src\\com\\oop\\homework\\hw01\\zt5input.txt"));
        T5 solve = new T5();
        int[] cnt = new int[101];
        while (in.hasNext()) cnt[in.nextInt()]++;
        solve.printH(cnt);
        solve.printV(cnt);
    }

    /**
     * Print the image in horizon
     *
     * @param cnt the frequency table
     */
    public void printH(int[] cnt) {
        for (int i = 0; i <= 90; i++) if (i % 10 == 9) printS(cnt, i - 9, i);
        printS(cnt, 90, 100);
    }

    /**
     * Print stars
     *
     * @param cnt frequency table
     * @param src begin idx
     * @param dst end idx
     */
    private void printS(int[] cnt, int src, int dst) {
        if (dst % 10 == 9) System.out.printf("%2d - %2d: ", dst - 9, dst);
        else if (dst == 100) System.out.print("90 -100: ");
        int s = 0;
        for (int i = src; i <= dst; i++) s += cnt[i];
        for (int i = 0; i < s; i++) System.out.print("*");
        System.out.println();
    }

    /**
     * Print the image vertically
     *
     * @param cnt frequency table
     */
    public void printV(int[] cnt) {
        int[] set = new int[10];
        int h = height(cnt, set), now = h;
        for (int i = 0; i < h; i++, now--) {
            for (int j = 0; j < 10; j++) {
                if (set[j] >= now) System.out.print("   *   ");
                else System.out.print("       ");
            }
            System.out.println();
        }
        for (int i = 0; i < 9; i++) System.out.printf(" %2d-%2d ", 10 * i, 10 * i + 9);
        System.out.printf(" %2d-%2d ", 90, 100);
    }

    /**
     * Get the max height
     *
     * @param cnt frequency table
     * @param set divide the numbers into ten sets
     * @return the max height
     */
    private int height(int[] cnt, int[] set) {
        int[] s = new int[101]; // prefix sum
        s[0] = cnt[0];
        for (int i = 1; i < 101; i++) s[i] = s[i - 1] + cnt[i];

        int h = 0, last = 0, st = 0;
        for (int i = 9; i <= 89; i += 10) {
            int freq = i == 9 ? s[9] : s[i] - s[i - 10];
            set[st++] = freq;
            h = Math.max(h, freq);
        }
        for (int i = 90; i <= 100; i++) last += cnt[i];
        set[st] = last;

        return Math.max(h, last);
    }
}
