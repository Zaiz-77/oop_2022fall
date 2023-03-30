package com.oop.homework.exp.mysweeper;

import javax.swing.*;

public class Timer extends JLabel {
    private int timer;
    private boolean running = false;
    public Counter counter;

    public Timer(String s, int h) {
        setText(s + timer);
        setHorizontalAlignment(h);
        this.counter = new Counter();
        counter.start();
        updateUI();
        setAlignmentX(LEFT_ALIGNMENT);
    }

    private class Counter extends Thread {
        public void run() {
            while (true) {
                if (running) timer++;
                setText("" + timer);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void pause() {
        running = false;
    }

    public void start() {
        running = true;
    }

    public void reset() {
        running = false;
        timer = 0;
    }

    public boolean isRunning() {return running;}
}
