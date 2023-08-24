package com.company;

import javax.swing.*;
import java.awt.event.*;

public class Game {

    public static void main(String[] args)  {
        Gui gui = new Gui();
        Board board = new Board();

        board.addNewNumber();
        board.addNewNumber();

        gui.go(board);
    }

}
