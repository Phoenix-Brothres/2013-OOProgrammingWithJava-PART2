/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mika
 */
public class AverageSensor implements Sensor {
    
    private List<Sensor> sensors = new ArrayList<Sensor>();
    private List<Integer> readings = new ArrayList<Integer>(); 

    public AverageSensor() {
    }
    
    public void addSensor(Sensor additional) {
        this.sensors.add(additional);
    }

    @Override
    public boolean isOn() {
        for (Sensor s : sensors) {
            if (!s.isOn())
                return false;
        }
        return true;
    }

    @Override
    public void on() {
        for (Sensor s : sensors) {
            s.on();
        }
    }

    @Override
    public void off() {
        for (Sensor s : sensors) {
            s.off();
        }
    }

    @Override
    public int measure() {
        if(sensors.isEmpty() || !this.isOn()) {
            throw new IllegalStateException();
        } else {
            int avg = 0;
            for (Sensor s : sensors) {
                avg += s.measure();
            }
            avg /= sensors.size();
            this.readings.add(avg);
            return avg;
        }
    }
    
    public List<Integer> readings() {
        return this.readings;
    }
}
