/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.List;

/**
 *
 * @author Mika
 */
public class MovingObject {
    
    private int xPos;
    private int yPos;
    private int xLimit;
    private int yLimit;

    public MovingObject(int xPos, int yPos, int xLimit, int yLimit) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.xLimit = xLimit;
        this.yLimit = yLimit;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
    
    public void move(String s) {
        if (s.equals("w")) {
            if (yPos-1 >= 0) {
                yPos--;
            }
        } else if (s.equals("a")) {
            if (xPos-1 >= 0) {
                xPos--;
            }
        } else if (s.equals("s")) {
            if (yPos+1 < this.yLimit) {
                yPos++;
            }
        } else if (s.equals("d")) {
            if (xPos+1 < this.xLimit) {
                xPos++;
            }
        } 
    }
    
    public boolean checkObjectIsThere(int x, int y) {
        return (x == this.getxPos()) && (y == this.getyPos());
    }
    
    @Override
    public String toString() {
        return xPos+" "+yPos;
    }
}
