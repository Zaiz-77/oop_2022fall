package com.oop.homework.exp.mysweeper;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//这个类的作用就是充当“棋盘”
public class GameBoardPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    // 设定了“棋盘”中有多少个Cell对象
    private final int n, m, cnt, w, h;
    private int remain;
    private final Util util;
    // 每一个Cell对象的尺寸大小，依次大小再去计算“棋盘”的大小
    public static final int CELL_SIZE = 60;
    private final Cell[][] cells;


    public GameBoardPanel(int r, int c, int cnt) {
        this.n = r;
        this.m = c;
        this.cnt = this.remain = cnt;
        this.cells = new Cell[n][m];
        this.w = CELL_SIZE * m;
        this.h = CELL_SIZE * n;
        util = new Util();
        util.remain.setText("Remain:" + remain);
        util.reset.addActionListener(e -> newGame());
        JPanel body = new JPanel(new GridLayout(n, m, 1, 1));
        super.setLayout(new BorderLayout(10, 10));
        super.add(util, BorderLayout.NORTH);
        super.add(new JScrollPane(body), BorderLayout.CENTER);
        for (int row = 0; row < n; ++row) {
            for (int col = 0; col < m; ++col) {
                cells[row][col] = new Cell(row, col);
                cells[row][col].setMargin(new Insets(0, 0, 0, 0));
                body.add(cells[row][col]);
            }
        }
        // [TODO 3] 为所有的Cell单元对象创建一个共享的鼠标事件监听器
        CellMouseListener listener = new CellMouseListener();
        // [TODO 4] 通过下面的循环，将每个Cell对象的鼠标事件监听器对象设为listener
        for (int row = 0; row < n; ++row) {
            for (int col = 0; col < m; ++col) {
                cells[row][col].addMouseListener(listener);
            }
        }
        body.setPreferredSize(new Dimension(w, h));
    }

    // 初始化一个新的游戏
    public void newGame() {
        // 通过MineMap获得新游戏中的地雷数据的布局
        MineMap mineMap = new MineMap(n, m, cnt);
        // 根据mineMap中的数据初始化每个Cell单元对象
        for (int row = 0; row < n; ++row) {
            for (int col = 0; col < m; ++col) {
                cells[row][col].newGame(mineMap.isMined[row][col]);
            }
        }
        System.out.println("游戏已开始");
        remain = cnt;
        util.timer.reset();
        util.remain.setText("Remain:" + remain);
    }

    // 获得[srcRow, srcCol]Cell单元对象周围的8个邻居的地雷总数
    private int getSurroundingMines(int srcRow, int srcCol) {
        int numMines = 0;
        for (int row = srcRow - 1; row <= srcRow + 1; ++row) {
            for (int col = srcCol - 1; col <= srcCol + 1; ++col) {
                if (row >= 0 && row < n && col >= 0 && col < m)
                    if (cells[row][col].isMined) numMines++;
            }
        }
        return numMines;
    }

    // 对[srcRow, srcCol]Cell单元对象执行挖雷操作
    // 如果该单元格对象中的标记的雷的数量为0，那么就自动递归对其周围8个邻居执行挖雷操作
    private void revealCell(int srcRow, int srcCol) {
        int numMines = getSurroundingMines(srcRow, srcCol);
        cells[srcRow][srcCol].setText(numMines + "");
        cells[srcRow][srcCol].isRevealed = true;
        cells[srcRow][srcCol].paint();
        if (numMines == 0) {
            for (int row = srcRow - 1; row <= srcRow + 1; ++row) {
                for (int col = srcCol - 1; col <= srcCol + 1; ++col) {
                    if (row >= 0 && row < n && col >= 0 && col < m)
                        if (!cells[row][col].isRevealed) revealCell(row, col);
                }
            }
        }
    }

    // 用来判断玩家是否已经赢得此次游戏
    public boolean hasWon() {
        // 如果将所有单元格都成功执行了挖雷操作或者所有的地雷都被标记
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean good = cells[i][j].isRevealed || (cells[i][j].isMined && cells[i][j].isFlagged);
                if (!good) return false;
            }
        }
        return true;
    }

    public void resetGame() {
        for (Cell[] cell : cells) for (Cell c : cell) c.reset();
        remain = cnt;
        util.timer.reset();
        util.remain.setText("Remain:" + remain);
        System.out.println("游戏已重置");
    }

    public void sos() {
        JOptionPane.showMessageDialog(null, "请联系首页右下角邮箱 ↘ ");
    }

    private class CellMouseListener extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            if (!util.timer.isRunning()) util.timer.start();
            Cell sourceCell = (Cell) e.getSource();
            if (e.getButton() == MouseEvent.BUTTON1) solveLeftClick(sourceCell);
            else if (e.getButton() == MouseEvent.BUTTON3) solveRightClick(sourceCell);
            if (hasWon()) {
                util.timer.pause();
                JOptionPane.showMessageDialog(null, "恭喜取得胜利");
                System.out.println("取得胜利");
            }
        }
    }

    private void solveLeftClick(Cell sourceCell) {
        if (!sourceCell.isMined) revealCell(sourceCell.row, sourceCell.col);
        else {
            System.out.println("Game Over");
            util.timer.pause();
            sourceCell.setText("B");
            JOptionPane.showMessageDialog(null, "祝你下次好运");
            showSolution();
        }
    }

    private void solveRightClick(Cell sourceCell) {
        if (!sourceCell.isFlagged) {
            sourceCell.setText("F");
            sourceCell.isFlagged = true;
            remain--;
        } else {
            sourceCell.setText("");
            sourceCell.isFlagged = false;
            remain++;
        }
        util.remain.setText("Remain:" + remain);
    }

    private void showSolution() {
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) {
            if (cells[i][j].isMined) cells[i][j].setText("B");
            else {
                int now = getSurroundingMines(i, j);
                if (now != 0) cells[i][j].setText("" + now);
                cells[i][j].isRevealed = true;
            }
            cells[i][j].paint();
        }
    }
}
