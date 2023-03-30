package com.oop.homework.exp.mysweeper;

import javax.swing.*;
import java.awt.*;

public class Difficulty extends JFrame {
    JPanel header, body, footer;
    JLabel title, info, copyRight;
    String fontFamily = "等线";
    private static final int WIDTH = 600, HEIGHT = 600, LEVEL = 4, FONT_SIZE = 16;
    private static final JButton[] LEVELS = {
            new JButton("简单 8 x 8"),
            new JButton("适中 10 x 10"),
            new JButton("困难 16 x 16"),
            new JButton("炼狱 25 x 25")
    };

    public Difficulty() {
        initHeader();
        initBody();
        initFooter();
        initGUI();
    }

    private void initGUI() {
        Container cp = this.getContentPane();
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        cp.setLayout(new BorderLayout());
        cp.add(header, BorderLayout.NORTH);
        cp.add(body, BorderLayout.CENTER);
        cp.add(footer, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Choose Difficulty");
        setVisible(true);
    }

    private void initHeader() {
        header = new JPanel(new GridLayout(2, 1));
        title = new JLabel("MineSweeper", JLabel.CENTER);
        title.setFont(new Font(fontFamily, Font.BOLD, FONT_SIZE * 2));
        title.setForeground(Color.DARK_GRAY);
        info = new JLabel("选择你希望的难度", JLabel.CENTER);
        info.setFont(new Font(fontFamily, Font.BOLD, FONT_SIZE));
        info.setForeground(Color.DARK_GRAY);
        header.add(title);
        header.add(info);
    }

    private void initBody() {
        body = new JPanel(new GridLayout(2, 2, 5, 5));
        Color[] colors = {Color.GREEN, Color.BLUE, Color.YELLOW, Color.RED};
        for (int i = 0; i < LEVEL; i++) {
            LEVELS[i].setBorder(BorderFactory.createRaisedBevelBorder());
            LEVELS[i].setFont(new Font(fontFamily, Font.BOLD, FONT_SIZE));
            LEVELS[i].setBackground(colors[i]);
            chooseDifficulty(i);
            body.add(LEVELS[i]);
        }
    }

    private void initFooter() {
        footer = new JPanel(new GridLayout(1, 1));
        copyRight = new JLabel("zaizwk@gmail.com", JLabel.RIGHT);
        footer.add(copyRight);
    }

    private void chooseDifficulty(int i) {
        int n, m, num;
        if (i == 0) n = m = num = 8;
        else if (i == 1) {
            n = m = 10;
            num = 20;
        } else if (i == 2) {
            n = m = 16;
            num = 80;
        } else {
            n = m = 25;
            num = 250;
        }
        int r = n, c = m, cnt = num;
        LEVELS[i].addActionListener(e -> {
            setVisible(false);
            new MineSweeperMain(r, c, cnt);
        });
    }
}
