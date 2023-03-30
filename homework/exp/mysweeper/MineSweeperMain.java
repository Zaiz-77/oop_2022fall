package com.oop.homework.exp.mysweeper;

import javax.swing.*;
import java.awt.*;

/**
 * 挖雷游戏的主程序。
 * 单击鼠标左键对单元格执行挖雷操作。
 * 单击鼠标右键用来对单元格执行添加标记，或者移除标记，标记疑似有地雷的单元格。
 * 如果所有没有地雷的单元格都执行了挖雷操作，那么玩家赢得游戏。
 * 如果对某个有地雷的单元格执行了挖雷操作，那么玩家输。
 */
public class MineSweeperMain extends JFrame {
    private static final long serialVersionUID = 1L;
    GameBoardPanel board;
    MyMenu menu = new MyMenu();

    public MineSweeperMain(int r, int c, int cnt) {
        board = new GameBoardPanel(r, c, cnt);
        Container cp = this.getContentPane();
        cp.setLayout(new BorderLayout(10, 10));

        cp.add(menu, BorderLayout.NORTH);//菜单放置在窗口的北部
        cp.add(board, BorderLayout.CENTER);//棋盘放置在窗口的中部

        menu.items[0].addActionListener(e -> {
            setVisible(false);
            new Difficulty();
        });
        menu.solveAction(board);

        board.newGame();
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Minesweeper");
        setVisible(true);
    }

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        // [TODO 1] 使用安全的方式启动下面的构造函数
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        javax.swing.SwingUtilities.invokeLater(Difficulty::new);
    }
}
