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
public class MilkingRobot {
    
    private BulkTank connected;
    
    public MilkingRobot() {
        this.connected = null;
    }
            
    public BulkTank getBulkTank() {
        return this.connected;
    }

    public void setBulkTank(BulkTank tank) {
        this.connected = tank;
    }
    
    public void milk(Milkable milkable) {
        try {
            connected.addToTank(milkable.milk());
        } catch (Exception e){
            throw new IllegalStateException();
        }
    }
}
