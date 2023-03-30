package com.oop.homework.hw02;

import java.awt.*;

public class MyRectangle extends MyGraph implements Areable, Drawable {
    private int w, h;

    public MyRectangle() {
    }

    // 提供顶点和长和宽
    public MyRectangle(int x, int y, int w, int h, Color color) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = color;
    }

    // 提供顶点，长和宽默认是400，颜色默认黑色
    public MyRectangle(int x, int y) {
        this.x = x;
        this.y = y;
        this.w = this.h = 400;
        this.color = Color.BLACK;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.drawRect(x, y, w, h);
    }

    @Override
    public double calc() {
        return w * h;
    }

    @Override
    public void paint(Graphics g) {
        draw(g);
    }
}
