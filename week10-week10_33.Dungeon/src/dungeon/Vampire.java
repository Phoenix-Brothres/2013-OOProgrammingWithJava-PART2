/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.List;
import java.util.Random;

/**
 *
 * @author Mika
 */
public class Vampire extends MovingObject {

    public Vampire(int xPos, int yPos, int xLimit, int yLimit) {
        super(xPos, yPos, xLimit, yLimit);
    }

    public void move(List<Vampire> vamps) {
        String[] direction = {"w", "a", "s", "d"};
        String chosenDirection = direction[new Random().nextInt(4)];
        int xBeforeMove = this.getxPos();
        int yBeforeMove = this.getyPos();
        super.move(chosenDirection); //To change body of generated methods, choose Tools | Templates.
        int vampNumberOnThePlace = 0;
        for (Vampire v : vamps) {
            if ((this.getxPos() == v.getxPos()) && (this.getyPos() == v.getyPos())) {
                vampNumberOnThePlace++;
            }
        }
        if (vampNumberOnThePlace > 1) {
            this.setxPos(xBeforeMove);
            this.setyPos(yBeforeMove);
        }
    }
    
    @Override
    public String toString() {
        return "v "+super.toString();
    }
}