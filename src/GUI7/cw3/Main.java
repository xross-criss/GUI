package GUI7.cw3;

import javax.swing.JFrame;


public class Main {
    public static void main(String... args) {

        JTableDemo mainFrame = new JTableDemo();

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setLocationByPlatform(true);
        mainFrame.setVisible(true);

    }
}