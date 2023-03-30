package com.oop.homework.exp.mysweeper;

import javax.swing.*;
import java.awt.*;

public class Util extends JPanel {
    public Timer timer;
    public JLabel remain;
    public JButton reset;

    public Util() {
        super.setLayout(new GridLayout(1, 3));
        timer = new Timer("Time:", JLabel.CENTER);
        remain = new JLabel("Mine:", JLabel.CENTER);
        reset = new JButton("快速重开");
        timer.setFont(new Font("等线", Font.BOLD, 20));
        remain.setFont(new Font("等线", Font.BOLD, 20));
        reset.setFont(new Font("等线", Font.BOLD, 20));
        super.add(timer);
        super.add(reset);
        super.add(remain);
    }
}
