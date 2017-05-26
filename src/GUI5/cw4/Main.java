package GUI5.cw4;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        char input;
        String dialogExtraContent = "";

        while (true) {
            try {
                String dialog = JOptionPane.showInputDialog(
                        (dialogExtraContent.length() > 0 ? dialogExtraContent + "\n" : "") + "Wprowadź typ rozkładu(A-G)");

                if (dialog.length() > 1) {
                    throw new Exception("Możesz wprowadzić tylko jeden znak");
                } else {
                    input = dialog.charAt(0);
                    frame(input);
                }

                break;

            } catch (Exception e) {
                dialogExtraContent = e.getMessage();
            }
        }
    }

    private static void frame(char input) throws Exception {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 300));
        frame.setLocation(300, 300);

        switch (input) {
            case ('A'):
                frame.setTitle("A w układzie BorderLayou");
                frame.setLayout(new BorderLayout());
                break;

            case ('B'):
                frame.setTitle("B w układzie FlowLayout");
                frame.setLayout(new FlowLayout());
                break;

            case ('C'):
                frame.setTitle("C w układzie FlowLayout z wyrównaniem do lewej");
                frame.setLayout(new FlowLayout(FlowLayout.LEFT));
                break;

            case ('D'):
                frame.setTitle("D w układzie FlowLayout z wyrównaniem do prawej");
                frame.setLayout(new FlowLayout(FlowLayout.RIGHT));
                break;

            case ('E'):
                frame.setTitle("E w układzie GridLayout jako jeden wiersz");
                frame.setLayout(new GridLayout(1, 0, 1, 1));
                break;

            case ('F'):
                frame.setTitle("F jako jedną kolumnę");
                frame.setLayout(new GridLayout(0, 1, 1, 1));
                break;

            case ('G'):
                frame.setTitle(" jako tablice (3, 2)");
                frame.setLayout(new GridLayout(3, 2, 1, 1));
                break;

            default:
                throw new Exception("Nieprawidłowy parametr wejściowy");
        }

        for (int x = 0; x < 5; x++) {
            frame.getContentPane().add(
                    new JButton("Przycisk " + (x + 1)));
        }

        frame.pack();
        frame.setVisible(true);
    }
}
