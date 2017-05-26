package GUI5.cw1;

import javax.swing.*;

public class Net extends JFrame {

    public Net() {
        super("Net");
        add(new DrawingField(200, 250));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}