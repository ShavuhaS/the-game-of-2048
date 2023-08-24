package com.company;

import java.util.ArrayList;
import java.awt.event.*;

public class Board {

    Cell[][] cells = new Cell[4][4];

    public Board() {
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public void addNewNumber() {
        ArrayList<Integer> row = new ArrayList<Integer>();
        ArrayList<Integer> column = new ArrayList<Integer>();

        for(int i = 0; i < cells.length; i++) {
            for(int j = 0; j < cells[0].length; j++) {
                if(cells[i][j].getValue() == 0) {
                    row.add(i);
                    column.add(j);
                }
            }
        }

        int random = (int) ( Math.random() * row.size() );
        cells[row.get(random)][column.get(random)].setRandomValue();
    }

    public boolean combine(KeyEvent e) {
        boolean isChanged = false;
        switch(e.getKeyCode()) {
            case 39:
                for(Cell[] rows : cells) {
                    for(int j = 3; j > 0; j--) {
                        if(rows[j].getValue() == rows[j - 1].getValue() && rows[j].getValue() != 0) {
                            rows[j].setDoubleValue();
                            rows[j - 1].setVoidValue();
                            Gui.score += rows[j].getValue();
                            isChanged = true;
                        }
                    }
                }
            break;
            case 37:
                for(Cell[] rows : cells) {
                    for(int j = 0; j < 3; j++) {
                        if(rows[j].getValue() == rows[j + 1].getValue()  && rows[j].getValue() != 0) {
                            rows[j].setDoubleValue();
                            rows[j + 1].setVoidValue();
                            Gui.score += rows[j].getValue();
                            isChanged = true;
                        }
                    }
                }
            break;
            case 40:
                for(int j = 0; j < 4; j++) {
                    for(int i = 3; i > 0; i--) {
                        if(cells[i][j].getValue() == cells[i - 1][j].getValue() && cells[i][j].getValue() != 0) {
                            cells[i][j].setDoubleValue();
                            cells[i - 1][j].setVoidValue();
                            Gui.score += cells[i][j].getValue();
                            isChanged = true;
                        }
                    }
                }
            break;
            case 38:
                for(int j = 0; j < 4; j++) {
                    for(int i = 0; i < 3; i++) {
                        if(cells[i][j].getValue() == cells[i + 1][j].getValue() && cells[i][j].getValue() != 0) {
                            cells[i][j].setDoubleValue();
                            cells[i + 1][j].setVoidValue();
                            Gui.score += cells[i][j].getValue();
                            isChanged = true;
                        }
                    }
                }
            break;
        }

        return isChanged;
        //System.out.print(toString());
    } // ВОЗВРАЩАЕТ БУЛЕВУ ПЕРЕМЕННУЮ ДЛЯ ОТСЛЕЖИВАНИЯ ИЗМЕНЕНИЙ В cells[][]

    public boolean slide(KeyEvent e) {
        boolean isChanged = false;
        switch(e.getKeyCode()) {
            case 39:
                for(Cell[] row : cells) {
                for(int k = 0; k < 4; k++) {
                    for (int i = 3; i > 0; i--) {
                        if (row[i].getValue() == 0 && row[i - 1].getValue() != 0) {
                            row[i].cellToCell(row[i - 1]);
                            row[i - 1].setVoidValue();
                            isChanged = true;
                        }
                    }
                }
            }
            break;
            case 37:
                for(Cell[] row : cells) {
                    for(int k = 0; k < 4; k++) {
                        for (int i = 0; i < 3; i++) {
                            if (row[i].getValue() == 0 && row[i + 1].getValue() != 0) {
                                row[i].cellToCell(row[i + 1]);
                                row[i + 1].setVoidValue();
                                isChanged = true;
                            }
                        }
                    }
                }
            break;
            case 40:
                for(int j = 0; j < 4; j++) {
                    for(int k = 0; k < 4; k++) {
                        for (int i = 3; i > 0; i--) {
                            if (cells[i][j].getValue() == 0 && cells[i - 1][j].getValue() != 0) {
                                cells[i][j].cellToCell(cells[i - 1][j]);
                                cells[i - 1][j].setVoidValue();
                                isChanged = true;
                            }
                        }
                    }
                }
            break;
            case 38:
                for(int j = 0; j < 4; j++) {
                    for(int k = 0; k < 4; k++) {
                        for (int i = 0; i < 3; i++) {
                            if (cells[i][j].getValue() == 0 && cells[i + 1][j].getValue() != 0) {
                                cells[i][j].cellToCell(cells[i + 1][j]);
                                cells[i + 1][j].setVoidValue();
                                isChanged = true;
                            }
                        }
                    }
                }
            break;
        }

        return isChanged;
        //System.out.print(toString());
    } // ВОЗВРАЩАЕТ БУЛЕВУ ПЕРЕМЕННУЮ ДЛЯ ОТСЛЕЖИВАНИЯ ИЗМЕНЕНИЙ В cells[][]

    public String toString() {
        String s = "";

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                s += cells[i][j].getValue() + " ";
            }
            s += "\n";
        }

        return s;
    }
}
