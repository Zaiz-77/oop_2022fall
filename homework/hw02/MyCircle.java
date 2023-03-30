package com.oop.homework.hw02;

import java.awt.*;

public class MyCircle extends MyGraph implements Areable, Drawable {
	private int r;

	public MyCircle() {
	}

	// 坐标和半径以及颜色
	public MyCircle(int x, int y, int r, Color color) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.color = color;
	}

	// 只有半径时，默认在(400, 400)，颜色默认是黑色
	public MyCircle(int r) {
		this.x = this.y = 400;
		this.r = r;
		this.color = Color.BLACK;
	}

	// 有半径和颜色，坐标仍然默认是(400, 400)
	public MyCircle(int r, Color color) {
		this.x = this.y = 400;
		this.r = r;
		this.color = color;
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.drawOval(x, y, r, r);
	}

	@Override
	public double calc() {
		return Math.PI * r * r;
	}

	@Override
	public void paint(Graphics g) {
		draw(g);
	}
}
