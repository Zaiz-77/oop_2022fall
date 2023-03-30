package com.oop.homework.exp.mysweeper;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class MyMenu extends JMenuBar implements Serializable {
    private static final long serialVersionUID = 3944252560798350799L;
    JMenu[] menus = {new JMenu("通用"), new JMenu("帮助")};
    JMenuItem[] items = {
            new JMenuItem("回到主页"),
            new JMenuItem("新建游戏"),
            new JMenuItem("重置游戏"),
            new JMenuItem("退出"),
            new JMenuItem("救命啊")
    };

    public MyMenu() {
        Font font = new Font("宋体", Font.BOLD, 18);
        setBorder(BorderFactory.createRaisedSoftBevelBorder());
        for (int i = 0; i < 4; i++) menus[0].add(items[i]);
        menus[1].add(items[4]);
        for (JMenu menu : menus) {
            menu.setFont(font);
            add(menu);
        }
        for (JMenuItem item : items) item.setFont(font);
    }

    public void solveAction(GameBoardPanel board) {
        items[1].addActionListener(e -> board.newGame());
        items[2].addActionListener(e -> board.resetGame());
        items[3].addActionListener(e -> System.exit(0));
        items[4].addActionListener(e -> board.sos());
    }
}
