/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import wormgame.Direction;

/**
 *
 * @author Mika
 */
public class Piece {
    
    private int x;
    private int y;

    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public boolean runsInto(Piece piece) {
        return this.x == piece.getX() && this.y == piece.getY();
    }
    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("()");
        str.insert(1, this.x+","+this.y);
        return str.toString();
    }
    
}
