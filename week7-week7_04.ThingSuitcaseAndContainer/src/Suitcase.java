
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author WONSEOB
 */
public class Suitcase {
    
    private ArrayList<Thing> things;
    private int maxWeight;

    public Suitcase(int maxWeight) {
        this.things = new ArrayList<Thing>();
        this.maxWeight = maxWeight;
    }

    public void addThing(Thing thing) {
        int currentWeight = 0;
        for (Thing t : things) {
            currentWeight += t.getWeight();
        }
        currentWeight += thing.getWeight();
        if (maxWeight >= currentWeight) {
            this.things.add(thing);
        }
    }
    
    public int totalWeight() {
        int total = 0;
        int currentWeight = 0;
        for (Thing t : things) {
            currentWeight += t.getWeight();
        }
        return currentWeight;
    }
    
    public void printThings() {
        for (Thing t : things) {
            System.out.println(t);
        }
    }
    
    public Thing heaviestThing() {
        Thing heaviest = null;
        if (!things.isEmpty()) {
            heaviest = things.get(0);
            for (Thing t : things) {
                if (heaviest.getWeight() < t.getWeight())
                    heaviest = t;
            }
        }
        return heaviest;
    }
            
    public String toString() {
        int currentWeight = 0, numOfThings = 0;
        String singOrPlr = "things";
        for (Thing t : things) {
            currentWeight += t.getWeight();
            numOfThings++;
        }
        if (numOfThings == 0) {
            return "empty (0 kg)";
        } else {
            if (numOfThings == 1)
                singOrPlr = "thing";
            return numOfThings+" "+singOrPlr+" (" +currentWeight+" kg)";
        }
    }
}
