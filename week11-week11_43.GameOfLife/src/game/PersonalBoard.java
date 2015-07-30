/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gameoflife.GameOfLifeBoard;
import java.util.Random;

/**
 *
 * @author Mika
 */
public class PersonalBoard extends GameOfLifeBoard {

    public PersonalBoard(int width, int height) {
        super(width, height);
    }

    @Override
    public void initiateRandomCells(double probabilityForEachCell) {
        boolean[][] board = getBoard();
        Random ran = new Random();
        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                if (ran.nextDouble() < probabilityForEachCell) {
                    board[i][j] = true;
                }
            }
        }
    }

    @Override
    public boolean isAlive(int x, int y) {
        if (checkRange(x, y)) {
            boolean[][] board = getBoard();
            return board[x][y];
        } else {
            return false;
        }
    }

    @Override
    public void turnToLiving(int x, int y) {
        if (checkRange(x, y)) {
            boolean[][] board = getBoard();
            board[x][y] = true;
        }
    }

    @Override
    public void turnToDead(int x, int y) {
        if (checkRange(x, y)) {
            boolean[][] board = getBoard();
            board[x][y] = false;
        }
    }

    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {
        int howMany = 0;
        boolean[][] board = getBoard();
        // check north west, north, north east
        if ((x - 1) >= 0) { // make sure you don't access to outside board
            if ((y - 1) >= 0) { // make sure you don't access to outside board
                if ((board[x - 1][y - 1]) == true) // check north west
                {
                    howMany++; //
                }
            }
            if ((board[x - 1][y]) == true) // check north
            {
                howMany++; //
            }
            if ((y + 1) <= (getHeight() - 1)) { // make sure you don't access to outside board
                if ((board[x - 1][y + 1]) == true) // check north east
                {
                    howMany++; // 
                }
            }
        }
        // check south west, south, south east 
        if ((x + 1) <= (getWidth() - 1)) { // make sure you don't access to outside board
            if ((y - 1) >= 0) { // make sure you don't access to outside board
                if (board[x + 1][y - 1] == true) // check south west
                {
                    howMany++;
                }
            }
            if (board[x + 1][y] == true) // check south
            {
                howMany++;
            }
            if ((y + 1) <= (getHeight() - 1)) { // make sure you don't access to outside board
                if (board[x + 1][y + 1] == true) // check north east
                {
                    howMany++; // 
                }
            }
        }
        // check due west, due east 
        if ((y - 1) >= 0) { // make sure you don't access to outside board
            if (board[x][y - 1] == true) // check due west
            {
                howMany++; //
            }
        }
        if ((y + 1) <= (getHeight() - 1)) { // make sure you don't access to outside board
            if (board[x][y + 1] == true) // check due east
            {
                howMany++;
            }
        }
        return howMany;
    }

    @Override
    public void manageCell(int x, int y, int livingNeighbours) {
        /* Every living cell dies if they have less than two living neighbours.
         Every living cell keeps on living during the following iteration (i.e. turn) if they have two or three living neighbours.
         Every living cell dies if they have more than three living neighbours.
         Every dead cell is turned back to life if they have exactly three living neighbours. */

        boolean[][] board = getBoard();

        if (livingNeighbours < 2) {
            turnToDead(x, y);
        } else if ((livingNeighbours == 2 || livingNeighbours == 3) && isAlive(x, y)) {
            
        } else if (livingNeighbours > 3) {
            turnToDead(x, y);
        } else if (livingNeighbours == 3) {
            turnToLiving(x, y);
        }
    }

    private boolean checkRange(int x, int y) {
        return (x >= 0 && x < getWidth()) && (y >= 0 && y < getHeight());
    }
}
