package com.company;

public class Cell {

    private int value;

    public Cell() {
        this.value = 0;
    }

    public int getValue() {
        return value;
    }

    public void setDoubleValue() {
        value *= 2;
    }

    public void setVoidValue() {
        value = 0;
    }

    public void setRandomValue() {
        int random = (int) ( Math.random() * 10 );

        if (random == 0) value = 4;
        else value = 2;
    }

    public void cellToCell(Cell cell) {
        value = cell.getValue();
    }
}
