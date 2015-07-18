/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WONSEOB
 */
public class Box implements Thing {
    
    private int maximumCapacity;
    private List<Thing> things;

    public Box(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        this.things = new ArrayList<Thing>();
    }
    
    public boolean addThing(Thing thing) {
        int currentVolume = 0;
        for (Thing t : things) {
            currentVolume += t.getVolume();
        }
        if ((currentVolume+thing.getVolume()) > maximumCapacity) {
            return false;
        } else {
            things.add(thing);
            return true;
        }
    }

    @Override
    public int getVolume() {
        int currentVolume = 0;
        for (Thing t : things) {
            currentVolume += t.getVolume();
        }
        return currentVolume;
    }
}
