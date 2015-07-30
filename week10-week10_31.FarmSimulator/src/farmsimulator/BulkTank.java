/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

/**
 *
 * @author Mika
 */
public class BulkTank {
    
    private double capacity;
    private double volume;

    public BulkTank() {
        this.capacity = 2000;
        this.volume = 0;
    }

    public BulkTank(double capacity) {
        this.capacity = capacity;
        this.volume = 0;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getVolume() {
        return volume;
    }
    
    public double howMuchFreeSpace() {
        return capacity - volume;
    }
    
    public void addToTank(double amount) {
        this.volume += amount;
        if (volume > capacity) {
            this.volume = capacity;
        }
    }
    
    public double getFromTank(double amount) {
        if (amount > volume) {
            double takenAmount = volume;
            volume = 0;
            return takenAmount;
        } else {
            volume -= amount;
            return amount;
        }
    }

    @Override
    public String toString() {
        return Math.ceil(this.volume)+"/"+Math.ceil(this.capacity);
    }
    
    
}
