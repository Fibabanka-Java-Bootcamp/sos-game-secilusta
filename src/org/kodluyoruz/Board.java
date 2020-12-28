package org.kodluyoruz;

import com.sun.tools.corba.se.idl.InvalidArgument;

public class Board {

    private Cell[][] board;
    private final StringBuilder horizontal = new StringBuilder("-------------");
    private final String vertical = "|";
    private int size;

    public Board(final int n) throws InvalidArgument {
        if (n < 3 || n > 7)
        {
            throw new InvalidArgument("Board size should be between [3-7]");
        }

        for (int i=3; i<n; i++) horizontal.append("----");

        board = new Cell[n][n];
        size = n;

        for (int i=0; i<n; i++)
        {
            for (int y=0; y<n; y++)
            {
                board[i][y] = new Cell();
            }
        }
    }

    public int getSize(){
        return size;
    }

    public void printBoard(){
        System.out.println(horizontal);
        for (Cell[] line: board) {
            for (Cell cell: line) {
                System.out.print(vertical);
                cell.printValue();
            }
            System.out.println(vertical);
            System.out.println(horizontal);
        }
    }

    public int getScoreOfBoard()
    {
        int score = 0;

        for (int row=0; row<board.length; row++) //rows
        {
            for (int column=0; column<board[row].length; column++) // columns
            {
                if (row+2 < board.length)
                if (board[row][column].getCellValue() == CellValue.S
                        &&
                        board[row+1][column].getCellValue() == CellValue.O
                        &&
                        board[row+2][column].getCellValue() == CellValue.S)
                {
                    score++;
                }
                if (column+2 < board[row].length)
                if (board[row][column].getCellValue() == CellValue.S
                        &&
                        board[row][column+1].getCellValue() == CellValue.O
                        &&
                        board[row][column+2].getCellValue() == CellValue.S)
                {
                    score++;
                }
                if (row+2 < board.length && column+2 < board[row].length)
                    if (board[row][column].getCellValue() == CellValue.S
                            &&
                            board[row+1][column+1].getCellValue() == CellValue.O
                            &&
                            board[row+2][column+2].getCellValue() == CellValue.S)
                    {
                        score++;
                    }
                if (row+2 < board.length && column-2 >= 0)
                    if (board[row][column].getCellValue() == CellValue.S
                            &&
                            board[row+1][column-1].getCellValue() == CellValue.O
                            &&
                            board[row+2][column-2].getCellValue() == CellValue.S)
                    {
                        score++;
                    }
            }
        }
        return score;
    }

    public boolean isThereEmptyCells(){
        for (Cell[] line: board) {
            for (Cell cell: line) {
                if (cell.getCellValue() == CellValue.EMPTY)
                    return true;
            }
        }
        return false;
    }
    public boolean isCellEmpty(int x, int y){
        return board[x][y].getCellValue() == CellValue.EMPTY;
    }

    public void play(int x, int y, CellValue value){
        board[x][y].setCellValue(value);
    }
}

/*
    public int getScoreOfMove(int x, int y, CellValue value)
    {
        int score = 0;
        int gap = 1;
        if (value == CellValue.S) gap = 2;

        for (int i=x-gap; i<board.length && i<x+gap; i++)
        {
            for (int j=y-gap; j<board[i].length && j<y+gap; j++)
            {
                if (board[i][j].getCellValue() == CellValue.S
                        &&
                        board[i+1][j].getCellValue() == CellValue.O
                        &&
                        board[i+2][j].getCellValue() == CellValue.S)
                {
                    System.out.println("yan");
                    score++;
                }
                if (board[i][j].getCellValue() == CellValue.S
                        &&
                        board[i][j+1].getCellValue() == CellValue.O
                        &&
                        board[i][j+2].getCellValue() == CellValue.S)
                {
                    System.out.println("dik");
                    score++;
                }
                if (board[i][j].getCellValue() == CellValue.S
                        &&
                        board[i+1][j+1].getCellValue() == CellValue.O
                        &&
                        board[i+2][j+2].getCellValue() == CellValue.S)
                {
                    System.out.println("çap");
                    score++;
                }
            }
        }
        return score;
    }
*/