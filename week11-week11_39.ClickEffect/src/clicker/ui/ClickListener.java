/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicker.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import clicker.applicationlogic.Calculator;
import javax.swing.JLabel;

/**
 *
 * @author Mika
 */
public class ClickListener implements ActionListener {

    private Calculator calc;
    private JLabel txt;

    public ClickListener(Calculator calc, JLabel txt) {
        this.calc = calc;
        this.txt = txt;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.calc.increase();
        this.txt.setText(""+this.calc.giveValue());
    }
}
