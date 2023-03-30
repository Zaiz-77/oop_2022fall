package com.oop.homework.exp.mysweeper;

import java.util.Random;

/**
 * 这个类主要用来存储地雷在单元格中的位置，目前这个类只是一个示意，所以地雷都是固定位置。
 */
public class MineMap {
    int n, m, numMines;
    boolean[][] isMined;

    public MineMap(int n, int m, int cnt) {
        this.n = n;
        this.m = m;
        this.isMined = new boolean[n][m];
        this.numMines = cnt;
        this.spanMineMap(cnt);
    }

    private void spanMineMap(int all) {
        Random rand = new Random(System.currentTimeMillis());
        int now = 0;
        while (now < all) {
            int x = rand.nextInt(n), y = rand.nextInt(m);
            isMined[x][y] = true;
            now++;
        }
    }
}
