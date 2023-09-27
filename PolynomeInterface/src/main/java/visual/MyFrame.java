package visual;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame (){
        this.setTitle("Polynome calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 750);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(0x123456));
    }
}
