
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
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
public class ResetListener implements ActionListener {

    private JTextField input;
    private JTextField output;
    private JButton resetBt;

    public ResetListener(JTextField input, JTextField output, JButton resetBt) {
        this.input = input;
        this.output = output;
        this.resetBt = resetBt;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        output.setText("0");
        input.setText("");
        resetBt.setEnabled(false);
    }
}
