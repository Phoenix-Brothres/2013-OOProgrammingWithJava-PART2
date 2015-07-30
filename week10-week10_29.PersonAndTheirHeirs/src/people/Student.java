/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

/**
 *
 * @author Mika
 */
public class Student extends Person {
    
    private int credit;

    public Student(String name, String address) {
        super(name, address);
        this.credit = 0;
    }

    
    public Student(int credit, String name, String address) {
        super(name, address);
        this.credit = credit;
    }
    
    public void study() {
        this.credit += 1;
    }
    
    public int credits() {
        return this.credit;
    }

    @Override
    public String toString() {
        return super.toString()+"\n  credits "+this.credits(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
