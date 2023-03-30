package com.oop.homework.hw02;

import java.awt.Color;
import javax.swing.JFrame;
import java.util.Random;

public class TestDraw {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            MyTime myTimer = new MyTime(21,33,22);
            DrawPanel panel = new DrawPanel(myTimer);
            JFrame application = new JFrame();
            application.setTitle("OOP hw02");
            application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            application.add(panel);
            application.setSize(800, 800);
            application.setVisible(true);
            while (true) {
                try {
                    Thread.sleep(1000); //设置绘制的时间间隔为 1 秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//正好也可以用来检验第 1 道题目中时钟类型的这个方法是否正确
                myTimer.incrementSecond();
//更新绘制图形面板上的内容（也就是绘制的图像）
                panel.updateUI();
            }
        });
        t.start();
    }

    public static MySpecial[] special() {
        Random rand = new Random();
        MySpecial[] specials = new MySpecial[5 + rand.nextInt(5)];
        for (int i = 0; i < specials.length; i++) {
            int x = rand.nextInt(400);
            int y = rand.nextInt(300);
            String name = "special" + i;
            Color color = new Color(rand.nextInt(256), rand.nextInt(256),
                    rand.nextInt(256));
            specials[i] = new MySpecial(x, y, name, color);
        }
        return specials;
    }

    public static MyRectangle[] generateRects() {
        Random rand = new Random();
        MyRectangle[] rects = new MyRectangle[5 + rand.nextInt(5)];
        for (int i = 0; i < rects.length; i++) {
            int x = rand.nextInt(400);
            int y = rand.nextInt(300);
            int w = rand.nextInt(400);
            int h = rand.nextInt(300);
            Color color = new Color(rand.nextInt(256), rand.nextInt(256),
                    rand.nextInt(256));
            rects[i] = new MyRectangle(x, y, w, h, color);
            System.out.println(rects[i].calc());
        }
        return rects;
    }

    public static MyCircle[] generateCircles() {
        Random rand = new Random();
        MyCircle[] circles = new MyCircle[5 + rand.nextInt(5)];
        for (int i = 0; i < circles.length; i++) {
            int x = rand.nextInt(400);
            int y = rand.nextInt(400);
            int r = rand.nextInt(400);
            Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            circles[i] = new MyCircle(x, y, r, color);
            System.out.println(circles[i].calc());
        }
        return circles;
    }

    public static MyLine[] generateLines() {
        Random rand = new Random();
        MyLine[] lines = new MyLine[5 + rand.nextInt(5)];
        for (int i = 0; i < lines.length; i++) {
            int x1 = rand.nextInt(400);
            int y1 = rand.nextInt(300);
            int x2 = rand.nextInt(400);
            int y2 = rand.nextInt(300);
            Color color = new Color(rand.nextInt(256), rand.nextInt(256),
                    rand.nextInt(256));
            lines[i] = new MyLine(x1, y1, x2, y2, color);
        }
        return lines;
    }

}
