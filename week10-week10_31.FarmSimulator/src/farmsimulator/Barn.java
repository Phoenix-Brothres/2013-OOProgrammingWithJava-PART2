/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.Collection;

/**
 *
 * @author Mika
 */
public class Barn {
    
    private MilkingRobot milkBot;
    private BulkTank connected;

    public Barn(BulkTank tank) {
        this.connected = tank;
        this.milkBot = null;
    }

    public BulkTank getBulkTank() {
        return connected;
    }
    
    public void installMilkingRobot(MilkingRobot milkingRobot) {
        this.milkBot = milkingRobot;
        this.milkBot.setBulkTank(connected);
    }
    
    public void takeCareOf(Cow cow) {
        try {
            this.milkBot.milk(cow);
        } catch (Exception e) {
            throw new IllegalStateException("The milking robot hasn't been installed");
        }
    }
    
    public void takeCareOf(Collection<Cow> cows) {
        for (Cow c : cows) {
            takeCareOf(c);
        }
    }
    
    public String toString() {
        return this.connected.toString();
    }
}
