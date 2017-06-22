package GUI7.cw3;


import javax.swing.*;
import java.awt.*;

public class JPageBookDetails extends JFrame{
    private JPanel topPanel;

    public JPageBookDetails(){
        setTitle("Spis książek");

        topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
    }
}