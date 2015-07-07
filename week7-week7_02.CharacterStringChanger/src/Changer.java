import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author WONSEOB
 */
public class Changer {
    
    private ArrayList<Change> Changes;

    public Changer() {
        Changes = new ArrayList<Change>();
    }

    public void addChange(Change change) {
        Changes.add(change);
    }
    
    public String change(String characterString) {
        for (Change ch : Changes) {
            characterString = ch.change(characterString);
        }
        return characterString;
    }
}
