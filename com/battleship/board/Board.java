package com.battleship.board;

import com.battleship.utils.Printer;

import java.util.Objects;

public class Board {
    private int hitCount = 0;

    private final String[][] board = {
            {" ","1","2","3","4","5","6","7","8","9","10"},
            {"A"," "," "," "," "," "," "," "," "," "," "},
            {"B"," "," "," "," "," "," "," "," "," "," "},
            {"C"," "," "," "," "," "," "," "," "," "," "},
            {"D"," "," "," "," "," "," "," "," "," "," "},
            {"E"," "," "," "," "," "," "," "," "," "," "},
            {"F"," "," "," "," "," "," "," "," "," "," "},
            {"G"," "," "," "," "," "," "," "," "," "," "},
            {"H"," "," "," "," "," "," "," "," "," "," "},
            {"I"," "," "," "," "," "," "," "," "," "," "},
            {"J"," "," "," "," "," "," "," "," "," "," "},
    };
    public void printBoard() {
        for (String[] line : board) {
            for (String position : line) {
                System.out.print("|" + position);
            }
            System.out.println("|");
        }
    }

    public void insertShips( int line,int column ){
        if(Objects.equals(board[line][column], " ")) {
            board[line][column] = "N";
        }
    }

    public void insertMove (int line,int column, boolean isPlayer ) {
        if(Objects.equals(board[line][column], " ")) {
            board[line][column] = "-";
            if (isPlayer) {
                Printer.waterHit();
            }
        } else if (Objects.equals(board[line][column], "N")) {
            board[line][column] ="*";
            this.hitCount++;
            if (isPlayer) {
            Printer.shipHit();
            }
        }
    }

    public Integer getHitCount() {
        return this.hitCount;
    }
}
