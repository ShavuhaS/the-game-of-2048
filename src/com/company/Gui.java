package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui {

    public static int score = 0;
    private static final int cellSize = 150;
    private static final int cellInterval = 30;
    private JFrame frame;


    public void go(Board board) {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addKeyListener(new MyKeyListener(board));

        MyDrawPanel drawPanel = new MyDrawPanel(board);

        frame.getContentPane().add(drawPanel);

        frame.setSize(cellSize * 4 + cellInterval * 5, cellSize * 4 + cellInterval * 5 + 150);
        frame.setVisible(true);
    }

    class MyKeyListener implements KeyListener {

        private Board board;

        public MyKeyListener(Board board) {
            this.board = board;
        }

        public void keyTyped(KeyEvent e) {

        }

        public void keyPressed(KeyEvent e) {
            // ВСТАВЬ СЮДА ОБРАБОТКУ КЛАВИАТУРЫ
            boolean slide1 = board.slide(e);
            boolean combine = board.combine(e);
            boolean slide2 = board.slide(e);

            if(slide1 || slide2 || combine) board.addNewNumber();

            frame.repaint();
        }

        public void keyReleased(KeyEvent e) {

        }
    }

    class MyDrawPanel extends JPanel {

        private Board board;

        MyDrawPanel(Board board) {
            this.board = board;
        }

        public void paintComponent(Graphics g) {
            g.setColor(new Color(187, 173, 160));
            g.fillRect(0, 150, 750,750);

            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 4; j++) {
                    switch(board.cells[i][j].getValue()) {
                        case 0: g.setColor(new Color(205, 193,180));
                            break;
                        case 2: g.setColor(new Color(238, 228,218));
                        break;
                        case 4: g.setColor(new Color(238, 225,201));
                        break;
                        case 8: g.setColor(new Color(243, 178,122));
                        break;
                        case 16: g.setColor(new Color(246, 150,100));
                        break;
                        case 32: g.setColor(new Color(247, 124,95));
                        break;
                        case 64: g.setColor(new Color(247, 97,60));
                        break;
                        case 128: g.setColor(new Color(237, 208,115));
                        break;
                        case 256: g.setColor(new Color(237, 204,98));
                        break;
                        case 512: g.setColor(new Color(244, 194,80));
                            break;
                        case 1024: g.setColor(new Color(243, 190,58));
                            break;
                        case 2048: g.setColor(new Color(248, 187,43));
                            break;
                        case 4096: g.setColor(new Color(255, 79,61));
                            break;
                        case 8192: g.setColor(new Color(255, 52,30));
                            break;
                        case 16384: g.setColor(new Color(255, 51,31));
                            break;
                    }

                    g.fillRect(j * cellSize + ((j + 1) * cellInterval), i * cellSize + (i + 1) * cellInterval + 150, cellSize, cellSize);

                    if(board.cells[i][j].getValue() > 4) g.setColor(new Color(249, 246, 242));
                    else g.setColor(new Color(119, 110, 101));

                    String value = "";
                    value += board.cells[i][j].getValue();
                    int fontSize = 30;
                    switch((int) Math.log10(board.cells[i][j].getValue())) {
                        case 0: fontSize = 100;
                        break;
                        case 1: fontSize = 75;
                            break;
                        case 2: fontSize = 60;
                            break;
                        case 3: fontSize = 45;
                            break;
                    }
                    g.setFont(new Font("Calibri", Font.BOLD, fontSize));
                    if(board.cells[i][j].getValue() != 0) {
                        g.drawString(value, (int) (j * cellSize + (j + 1) * cellInterval + cellSize / ((int) Math.log10(board.cells[i][j].getValue()) + 3)), (int) (i * cellSize + (i + 1) * cellInterval + 150 + cellSize * 2 / 3));
                    }
                }
            }

        }

    }

}
