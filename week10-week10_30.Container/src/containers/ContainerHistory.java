/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Mika
 */
public class ContainerHistory {

    private ArrayList<Double> containerHistory;

    public ContainerHistory() {
        this.containerHistory = new ArrayList<Double>();
    }

    public void add(double situation) {
        this.containerHistory.add(situation);
    }

    public void reset() {
        this.containerHistory.clear();
    }

    @Override
    public String toString() {
        return this.containerHistory.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    public double maxValue() {
        if (containerHistory == null) {
            return 0;
        } else {
            return Collections.max(containerHistory);
        }
    }

    public double minValue() {
        if (containerHistory == null) {
            return 0;
        } else {
            return Collections.min(containerHistory);
        }
    }

    public double average() {
        if (containerHistory == null) {
            return 0;
        } else {
            double avg = 0;
            for (double d : containerHistory) {
                avg += d;
            }
            return avg/containerHistory.size();
        }
    }
    
    public double greatestFluctuation() {
        if (containerHistory == null || containerHistory.size() == 1) {
            return 0;
        }
        double greatestFluc = 0, fluc = 0, lastVal = containerHistory.get(0);
        for (double d : containerHistory) {
            fluc = Math.abs(lastVal - d);
            if (fluc > greatestFluc) {
                greatestFluc = fluc;
            }
            lastVal = d;
        }
        return greatestFluc;
    }
    
    public double variance() {
        if (containerHistory == null || containerHistory.size() == 1) {
            return 0;
        }
        double variance = 0;
        for (double d : containerHistory) {
            variance += Math.pow(d-this.average(), 2);
        }
        return variance/(containerHistory.size() - 1);
    }
}
