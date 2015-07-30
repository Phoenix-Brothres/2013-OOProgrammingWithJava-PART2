/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.Random;

/**
 *
 * @author Mika
 */
public class Cow implements Milkable, Alive {
    
    private String name;
    private double capacity;
    private double availableMilk;
    
    private static final String[] NAMES = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    public Cow() {
        this.name = NAMES[new Random().nextInt(NAMES.length)];
        this.capacity = 15 + new Random().nextInt(26);
        this.availableMilk = 0;
    }

    public Cow(String name) {
        this.name = name;
        this.capacity = 15 + new Random().nextInt(26);
        this.availableMilk = 0;
    }

    public String getName() {
        return name;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getAmount() {
        return availableMilk;
    }
    
    @Override
    public double milk() {
        double amountToBeReturned = this.availableMilk;
        this.availableMilk = 0; //To change body of generated methods, choose Tools | Templates.
        return amountToBeReturned;
    }

    @Override
    public void liveHour() {
        this.availableMilk += (new Random().nextInt(14)+7)/10.0; //To change body of generated methods, choose Tools | Templates.
        if (this.availableMilk > this.capacity) {
            this.availableMilk = this.capacity;
        }
    }

    @Override
    public String toString() {
        return this.name+" "+Math.ceil(availableMilk)+"/"+Math.ceil(this.capacity);
    }
}
