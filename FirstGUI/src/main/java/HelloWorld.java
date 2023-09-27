
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class HelloWorld {

    public static void main(String[] args){
        final JFrame frame = new JFrame();
        frame.setBackground(Color.DARK_GRAY);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel firstPanel = new JPanel();
        JPanel secondPanel = new JPanel();

        firstPanel.setBounds(0, 0, 250, 250);
        firstPanel.setBackground(Color.BLUE);

        secondPanel.setBounds(0, 250, 500, 250);
        secondPanel.setBackground(Color.GREEN);

        JButton button = new JButton("Click here");

        final JLabel label = new JLabel("Hello there!");

        JTextField textField = new JTextField();
        textField.setColumns(10);
        label.setVisible(false);
        textField.setVisible(true);

        frame.add(firstPanel);
        frame.add(secondPanel);

        firstPanel.add(button);
        firstPanel.add(textField);

        secondPanel.add(label);

        frame.setSize(750,750);
        frame.setVisible(true);

        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                label.setText(textField.getText());
                label.setVisible(true);
            }
        });

    }
}
