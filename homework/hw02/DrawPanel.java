package com.oop.homework.hw02;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class DrawPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private Drawable[] graphs;
    private Drawable o;

    public DrawPanel() {
        setBackground(Color.BLACK);
    }

    public DrawPanel(Drawable[] graphs) {
        setBackground(Color.WHITE);
        if (graphs == null) return;
        if (!graphs.getClass().isArray()) return;
        this.graphs = graphs;
    }

    public DrawPanel(Drawable o) {
        setBackground(Color.WHITE);
        if (o == null) return;
        this.o = o;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.graphs == null) {
            o.paint(g);
            return;
        }
        for (Drawable graph : graphs) graph.paint(g);
    }
}
