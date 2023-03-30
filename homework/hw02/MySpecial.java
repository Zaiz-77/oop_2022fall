package com.oop.homework.hw02;

import java.awt.*;

public class MySpecial extends MyGraph implements Drawable {

    public MySpecial() {
    }

    public MySpecial(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public MySpecial(int x, int y, String name, Color color) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.color = color;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.drawString("This is a special graph" + name, x, y);
    }

    @Override
    public void paint(Graphics g) {
        draw(g);
    }
}
