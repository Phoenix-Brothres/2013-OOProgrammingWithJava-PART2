/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.logic;

import java.util.ArrayList;
import java.util.List;
import moving.domain.Box;
import moving.domain.Thing;

/**
 *
 * @author WONSEOB
 */
public class Packer {
    
    private int boxesVolume;

    public Packer(int boxesVolume) {
        this.boxesVolume = boxesVolume;
    }
    
    public List<Box> packThings(List<Thing> things) {
        List<Box> boxes = new ArrayList<Box>();
        boxes.add(new Box(this.boxesVolume));
        for (Thing t : things) {
            if (!boxes.get(boxes.size()-1).addThing(t)) {
                boxes.add(new Box(this.boxesVolume));
                boxes.get(boxes.size()-1).addThing(t);
            }
        }
        return boxes;
    }
}
