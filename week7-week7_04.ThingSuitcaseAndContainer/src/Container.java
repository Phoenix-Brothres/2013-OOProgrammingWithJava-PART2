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
public class Container {
    private int weightLimit;
    private ArrayList<Suitcase> suitcases;

    public Container(int weightLimit) {
        this.weightLimit = weightLimit;
        suitcases = new ArrayList<Suitcase>();
    }
    
    public void addSuitcase(Suitcase suitcase) {
        int currentWeight = 0;
        for (Suitcase s : suitcases) {
            currentWeight += s.totalWeight();
        }
        currentWeight += suitcase.totalWeight();
        if (weightLimit >= currentWeight) {
            this.suitcases.add(suitcase);
        }
    }
    
    public void printThings() {
        for (Suitcase s : suitcases) {
            s.printThings();
        }
    }
            
    public String toString() {
        int currentWeight = 0, numOfThings = 0;
        String singOrPlr = "suitcases";
        for (Suitcase s : suitcases) {
            currentWeight += s.totalWeight();
            numOfThings++;
        }
        if (numOfThings == 0) {
            return "empty (0 kg)";
        } else {
            if (numOfThings == 1)
                singOrPlr = "suitcase";
            return numOfThings+" "+singOrPlr+" (" +currentWeight+" kg)";
        }
    }
}
