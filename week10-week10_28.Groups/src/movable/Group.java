/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movable;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mika
 */
public class Group implements Movable {
    
    private List<Movable> group = new ArrayList<Movable>();
    
    public void addToGroup(Movable movable) {
        group.add(movable);
    }

    @Override
    public void move(int dx, int dy) {
        for (Movable obj : group) {
            obj.move(dx, dy);
        }
    }

    @Override
    public String toString() {
        String returnStr = "";
        for (Movable obj : group) {
            returnStr += obj;
            returnStr += "\n";
        }
        return returnStr;
    }
}
