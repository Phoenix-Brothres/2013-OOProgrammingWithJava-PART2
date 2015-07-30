/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

/**
 *
 * @author Mika
 */
public class ProductContainerRecorder extends ProductContainer {

    private ContainerHistory history;

    public ProductContainerRecorder(String productName, double capacity, double initialVolume) {
        super(productName, capacity);
        this.history = new ContainerHistory();
        this.addToTheContainer(initialVolume);
    }

    @Override
    public void addToTheContainer(double amount) {
        super.addToTheContainer(amount); 
        history.add(this.getVolume());
    }

    @Override
    public double takeFromTheContainer(double amount) {
        double prevVolume = this.getVolume();
        super.takeFromTheContainer(amount);
        history.add(this.getVolume());
        return prevVolume - this.getVolume();
    }
    
    public String history() {
        return history.toString();
    }
    
    public void printAnalysis() {
        System.out.println("Product: "+this.getName());
        System.out.println("History: "+this.history());
        System.out.println("Greatest product amount: "+history.maxValue());
        System.out.println("Smallest product amount: "+history.minValue());
        System.out.println("Average: "+history.average());
        System.out.println("Greatest change: "+history.greatestFluctuation());
        System.out.println("Variance: "+history.variance());
    }
}
