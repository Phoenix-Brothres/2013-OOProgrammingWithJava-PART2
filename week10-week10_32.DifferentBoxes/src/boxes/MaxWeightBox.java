/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mika
 */
public class MaxWeightBox extends Box {
    
    private int maxWeight;
    private List<Thing> things = new ArrayList<Thing>();

    public MaxWeightBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public void add(Thing thing) {
        int totalWeight = 0;
        for (Thing t : this.things) {
            totalWeight += t.getWeight();
        }
        if (totalWeight + thing.getWeight() <= this.maxWeight){
            things.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return this.things.contains(thing);
    }
    
}
