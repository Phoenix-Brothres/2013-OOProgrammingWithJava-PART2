/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author WONSEOB
 */
import java.util.ArrayList;

public class Box implements ToBeStored {
    
    private double maxWeight;
    private ArrayList<ToBeStored> things;

    public Box(double maxWeight) {
        this.maxWeight = maxWeight;
        this.things = new ArrayList<ToBeStored>();
    }
    
    public void add(ToBeStored thing) {
        double weightAfterAddition = this.weight() + thing.weight();
        if (!(weightAfterAddition > this.maxWeight))
            this.things.add(thing);
    }
    
    public double weight() {
        double weight=0;
        if (things == null) {
            return 0;
        }
        for (ToBeStored thing : things) {
            weight += thing.weight();
        }
        return weight;
    }
    
    @Override
    public String toString() {
        return "Box: "+this.things.size()+" things, total weight "+this.weight()+" kg";
    }
    
}
