package com.oop.homework.hw02;


import java.awt.*;
import java.util.*;

public class MyGraph implements Drawable {
    public String name;
    public int x, y;
    public Color color;

    public MyGraph() {
    }

    public MyGraph(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.color = Color.BLACK;
    }

    public MyGraph(String name, int x, int y, Color color) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.drawString("This is a graph", 0, 0);
    }

    @Override
    public void paint(Graphics g) {
        draw(g);
    }
}
