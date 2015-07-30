/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mika
 */
public class Farm implements Alive {
    
    private String owner;
    private Barn barn;
    private List<Cow> cows;

    public Farm(String owner, Barn barn) {
        this.owner = owner;
        this.barn = barn;
        cows = new ArrayList<Cow>();
    }

    public String getOwner() {
        return owner;
    }
    
    public void addCow(Cow cow) {
        this.cows.add(cow);
    }
    
    public void installMilkingRobot(MilkingRobot milkBot) {
        this.barn.installMilkingRobot(milkBot);
    }
    
    public void manageCows() {
        this.barn.takeCareOf(cows);
    }
    
    @Override
    public void liveHour() {
        for (Cow c : cows) {
            c.liveHour();
        }
    }

    @Override
    public String toString() {
        String str = "Farm owner: " + this.getOwner();
        str = str + "\nBarn bulk tank: " + this.barn.toString();
        str = str + "\nAnimals:";
        for (Cow c : cows) {
            str += "        " + c.toString();
        }
        return str;
    }
}
