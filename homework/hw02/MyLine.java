package com.oop.homework.hw02;

import java.awt.Graphics;
import java.awt.Color;

public class MyLine extends MyGraph implements Drawable {
    private int x1, y1, x2, y2;

    public MyLine() {
    }

    public MyLine(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);
    }

    @Override
    public void paint(Graphics g) {
        draw(g);
    }
}
