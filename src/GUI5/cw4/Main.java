package GUI5.cw4;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        char input;
        String dialogExtraContent = "";

        while (true) {
            try {
                input = JOptionPane.showInputDialog(
                        (dialogExtraContent.length() > 0 ? dialogExtraContent
                                + "\n" : "")
                                + "Wprowadź typ rozkładu(A-G)").charAt(0);

                // okno
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(new Dimension(300, 300));
                frame.setLocation(300, 300);

                if (input == 'A') { // a) w układzie BorderLayou
                    frame.setTitle("A w układzie BorderLayou");
                    frame.setLayout(new BorderLayout());
                } else if (input == 'B') { // b) w układzie FlowLayout
                    frame.setTitle("B w układzie FlowLayout");
                    frame.setLayout(new FlowLayout());
                } else if (input == 'C') { // c) w układzie FlowLayout z wyrównaniem do lewej
                    frame
                            .setTitle("C w układzie FlowLayout z wyrównaniem do lewej");
                    frame.setLayout(new FlowLayout(FlowLayout.LEFT));
                } else if (input == 'D') { // d) w układzie FlowLayout z wyrównaniem do prawej
                    frame
                            .setTitle("D w układzie FlowLayout z wyrównaniem do prawej");
                    frame.setLayout(new FlowLayout(FlowLayout.RIGHT));
                } else if (input == 'E') { // e) w układzie GridLayout jako jeden wiersz
                    frame.setTitle("E w układzie GridLayout jako jeden wiersz");
                    frame.setLayout(new GridLayout(1, 0, 1, 1));
                } else if (input == 'F') { // f) jako jedną kolumnę
                    frame.setTitle("F jako jedną kolumnę");
                    frame.setLayout(new GridLayout(0, 1, 1, 1));
                } else if (input == 'G') { // g) jako tablice (3, 2)
                    frame.setTitle(" jako tablice (3, 2)");
                    frame.setLayout(new GridLayout(3, 2, 1, 1));
                } else {
                    throw new Exception("Nieprawidłowy parametr wejściowy");
                }

                // przyciski
                for (int x = 0; x < 5; x++) {
                    frame.getContentPane().add(
                            new JButton("Przycisk " + (x + 1)));
                }

                // pakowanie i wyswietlanie
                frame.pack();
                frame.setVisible(true);

                break;
            } catch (Exception e) {
                dialogExtraContent = e.getMessage();
            }
        }
    }
}
