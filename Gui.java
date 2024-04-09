import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gui implements ActionListener {
    int count = 0;
    JLabel label;

    public Gui() {

        JFrame frame = new JFrame(); // Creates Jframe object

        JPanel panel = new JPanel(); // Creates Jpanel object
        JButton button = new JButton("Click me"); // Creates Jbutton object
        button.addActionListener(this);
        label = new JLabel("Number of clicks: " + count);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER); // Add panel to frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Add close operation
        frame.setTitle("Test Gui"); // Set titel
        frame.pack();
        frame.setVisible(true);

        // frame.add(button);
    }

    public static void main(String[] args) {
        new Gui();

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        count++;
        label.setText("Number of clicks: " + count);
    }

}