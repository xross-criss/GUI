/**
 * Treść zadania:
 * Stworzyć JListę, pokazująca informacje o temperaaturze w postaci:
 * k stopni C = f stopni F
 * <p>
 * gdzie k zmienia się od -70 do +60.
 * <p>
 * Uwaga: nie wolno używać tablic ani kolekcji.
 */
package GUI7.cw1;

import javax.swing.JFrame;


public class Main {
    public static void main(String... args) {

        // utworzenie instancji okna głównego aplikacji
        CelsiusFahrenheitJList mainFrame = new CelsiusFahrenheitJList();

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setLocationByPlatform(true);
        mainFrame.setVisible(true);


    }
}