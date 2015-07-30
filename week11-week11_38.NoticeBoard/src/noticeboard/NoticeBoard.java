package noticeboard;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class NoticeBoard implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(500,350));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        container.setLayout(layout);
        JTextField txtField = new JTextField();
        JButton button = new JButton("Copy!");
        JLabel txt = new JLabel("");
        ActionEventListener ae = new ActionEventListener(txtField, txt);
        button.addActionListener(ae);
        container.add(txtField);
        container.add(button);
        container.add(txt);
    }
}
