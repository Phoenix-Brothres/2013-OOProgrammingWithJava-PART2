/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author WONSEOB
 */
import java.util.HashMap;
import java.util.ArrayList;

public class VehicleRegister {
    
    private HashMap<RegistrationPlate, String> owners;

    public VehicleRegister() {
        this.owners = new HashMap<RegistrationPlate, String>();
    }
    
    public boolean add(RegistrationPlate plate, String owner) {
        if (this.owners.get(plate) == null) {
            this.owners.put(plate, owner);
            return true;
        } else {
            return false;
        }
    }
    
    public String get(RegistrationPlate plate) {
        if (this.owners.get(plate) == null) {
            return null;
        } else {
            return this.owners.get(plate);
        }
    }
    
    public boolean delete(RegistrationPlate plate) {
        if (this.owners.get(plate) == null) {
            return false;
        } else {
            this.owners.remove(plate);
            return true;
        }
    }
    
    public void printRegistrationPlates() {
        for (RegistrationPlate rp : owners.keySet()) {
            System.out.println(rp);
        }
    }
    
    public void printOwners() {
        ArrayList<String> ownersWithoutDup = new ArrayList<String>();
        for (String owner : owners.values()) {
            if (!ownersWithoutDup.contains(owner))
                ownersWithoutDup.add(owner);
        }
        for (String owner : ownersWithoutDup) {
            System.out.println(owner);
        }
    }
}
