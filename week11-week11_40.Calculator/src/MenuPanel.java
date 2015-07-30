
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mika
 */
public class MenuPanel extends JPanel {
    
    private JTextField input;
    private JTextField output;
    
    public MenuPanel(JTextField input, JTextField output) {
        super(new GridLayout(1, 3));
        this.input = input;
        this.output = output;
        createComponents();
    }
    
    private void createComponents() {
        JButton plusBt = new JButton("+");
        JButton minusBt = new JButton("-");
        JButton resetBt = new JButton("Z");
        PlusListener plusListen = new PlusListener(input, output, resetBt);
        MinusListener minusListen = new MinusListener(input, output, resetBt);
        ResetListener resetListen = new ResetListener(input, output, resetBt);
        plusBt.addActionListener(plusListen);
        minusBt.addActionListener(minusListen);
        resetBt.addActionListener(resetListen);
        resetBt.setEnabled(false);
        add(plusBt);
        add(minusBt);
        add(resetBt);
    }
}
