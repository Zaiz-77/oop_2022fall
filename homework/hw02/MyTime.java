package com.oop.homework.hw02;

import java.awt.*;

public class MyTime implements Drawable {
    private int h, m, s;

    public MyTime() {
        this.h = this.m = this.s = 0;
    }

    public MyTime(int h) {
        this.h = h;
    }

    public MyTime(int h, int m) {
        this.h = h;
        this.m = m;
    }

    public MyTime(int h, int m, int s) {
        this.h = h;
        this.m = m;
        this.s = s;
    }

    public MyTime(MyTime init) {
        this.h = init.h;
        this.m = init.m;
        this.s = init.s;
    }

    public void incrementHour() {
        h = (h + 1) % 24;
    }

    public void incrementMinute() {
        int t = m;
        m = (m + 1) % 60;
        if (t == 59) incrementHour();
    }

    public void incrementSecond() {
        int t = s;
        s = (s + 1) % 60;
        if (t == 59) incrementMinute();
    }

    private boolean invalid() {
        boolean ok1 = h >= 0 && h <= 23;
        boolean ok2 = m >= 0 && m <= 59;
        boolean ok3 = s >= 0 && s <= 59;

        if (!ok1) System.out.println("hour must be 0 - 24");
        if (!ok2) System.out.println("minute must be 0 - 59");
        if (!ok3) System.out.println("second must be 0 - 59");

        return !ok1 || !ok2 || !ok3;
    }

    public String toUniversalString() {
        if (invalid()) return "";
        String th = String.valueOf(h), tm = String.valueOf(m), ts = String.valueOf(s);
        String rh = h >= 10 ? th : "0" + th;
        String rm = m >= 10 ? tm : "0" + tm;
        String rs = s >= 10 ? ts : "0" + ts;
        return rh + ":" + rm + ":" + rs;
    }

    @Override
    public String toString() {
        if (invalid()) return "";
        String ap = h >= 12 ? "PM" : "AM";
        String th = String.valueOf(h % 12), tm = String.valueOf(m), ts = String.valueOf(s);
        String rh = (h % 12) >= 10 ? th : "0" + th;
        if (h % 12 == 0) rh = "12";
        String rm = m >= 10 ? tm : "0" + tm;
        String rs = s >= 10 ? ts : "0" + ts;
        return rh + ":" + rm + ":" + rs + " " + ap;
    }

    @Override
    public void paint(Graphics g) {
        MyCircle circle = new MyCircle(100, 100, 600, Color.BLACK);
        double l1 = 280, l2 = 150 * Math.sqrt(2), l3 = Math.sqrt(40250);
        MyLine s = new MyLine(400, 400, (int) (400 + l1 * Math.sin(1.0 * this.s * Math.PI / 30)), (int) (400 - l1 * Math.cos(1.0 * this.s * Math.PI / 30)), Color.RED);
        MyLine m = new MyLine(400, 400, (int) (400 + l2 * Math.sin(1.0 * this.m * Math.PI / 30)), (int) (400 - l2 * Math.cos(1.0 * this.m * Math.PI / 30)), Color.BLUE);
        MyLine h = new MyLine(400, 400, (int) (400 + l3 * Math.sin(1.0 * this.h * Math.PI / 6)), (int) (400 - l3 * Math.cos(1.0 * this.h * Math.PI / 6)), Color.MAGENTA);
        circle.paint(g);
        s.paint(g);
        m.paint(g);
        h.paint(g);
        g.drawString("12", 400, 100);
        g.drawString("3", 700, 400);
        g.drawString("6", 400, 700);
        g.drawString("9", 100, 400);
    }
}
