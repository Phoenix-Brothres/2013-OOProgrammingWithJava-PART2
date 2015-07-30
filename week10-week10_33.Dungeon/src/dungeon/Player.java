/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mika
 */
public class Player extends MovingObject {

    public Player(int length, int height) {
        super(0, 0, length, height);
    }

    public void killVamp(List<Vampire> vamps) {
        ArrayList<Vampire> toBeKilled = new ArrayList<Vampire>();
        for (Vampire v : vamps) {
            if ((this.getxPos() == v.getxPos()) && (this.getyPos() == v.getyPos())) {
                toBeKilled.add(v);
            }
        }
        vamps.removeAll(toBeKilled);
    }

    @Override
    public String toString() {
        return "@ " + super.toString();
    }
}
