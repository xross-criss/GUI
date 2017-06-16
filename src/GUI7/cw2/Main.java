package GUI7.cw2;

import javax.swing.JFrame;

public class Main {
    public static void main(String... args) {

        // utworzenie instancji okna głównego aplikacji
        JListDemo mainFrame = new JListDemo();

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setLocationByPlatform(true);
        mainFrame.setVisible(true);

    }
}