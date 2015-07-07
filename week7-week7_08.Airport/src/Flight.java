/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author WONSEOB
 */
public class Flight {
    
    private Airplane plane;
    private String departureCode;
    private String destinationCode;

    public Flight(Airplane plane, String departureCode, String destinationCode) {
        this.plane = plane;
        this.departureCode = departureCode;
        this.destinationCode = destinationCode;
    }

    @Override
    public String toString() {
        return plane + " (" + this.departureCode + "-" + this.destinationCode +")";
    }
}
