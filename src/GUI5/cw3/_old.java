package GUI5.cw3;


import javax.swing.*;
import java.awt.*;


public class _old {


    /**
     * Zad 1. Właściwości komponentów (max. 5p)
     * <p>
     * Stworzyć okno ramowe JFrame z tytułem "Prosty edytor", zawierające komponent
     * JTextArea (wielowierszowe pole edycyjne).
     * Zapewnić możliwość ustawiania z wiersza poleceń (przy uruchamianiu aplikacji)
     * rodzaju i rozmiaru pisma oraz kolorów tła i pisma.
     * <p>
     * Argumenty wywołania:
     * typ pisma (np. "Dialog", "Serif", "Monospaced")
     * rozmiar pisma
     * trójka RGB, określająca kolor tła
     * trójka RGB, określająca kolor pisma Domyślne wartości
     * <p>
     * Jeśli w wywołaniu nie podano argumentów, domyślne wartości winny być takie:
     * typ pisma = "Dialog"
     * rozmiar pisma = 14
     * kolor tła = niebieski
     * kolor pisma = biały
     * <p>
     * Wywołanie aplikacji powinno być możliwe:
     * bez argumentów
     * tylko rodzaj pisma
     * rodzaj pisma i rozmiar pisma
     * jw. + kolor tła (trzy liczby)
     * jw. + kolor pisma (trzy liczby)
     * <p>
     * Np.
     * java Zad1 -> niebieski edytor z pismem Dialog 14 w kolorze białym
     * java Zad1 Monospaced -> niebieski edytor z pismem Monospaced 14 w kolorze białym
     * java Zad1 Dialog 18  -> niebieski edytor z pismem Dialog 18 w kolorze białym
     * java Zad1 Dialog 18 0 0 0 -> czarny edytor z pismem Dialog 18 w kolorze białym
     * java Zad1 Dialog 18 255 255 255 0 0 0 -> biały edytor z pismem jw.
     *
     * @author s8376
     */
    public class Zadanie06_1 extends JTextArea {

        static String fontFace = "Dialog";
        static int fontSize = 14;
        static float fontColorR = 255 / 255, fontColorB = 255 / 255, fontColorG = 255 / 255;
        static float backgroundColorR = 0, backgroundColorB = 0,
                backgroundColorG = 255 / 255;

        /**
         * @param params
         * @param index
         * @param defaultValue
         * @return
         */
        private static float parse(String[] params, int index, float defaultValue) {

            float returnValue;
            try {
                returnValue = Float.parseFloat(params[index]) / 255;
                if (returnValue < 0 || returnValue > 1) {
                    throw new Exception("Out of otder");
                }
                return returnValue;
            } catch (Exception e) {
                return defaultValue;
            }
        }

        /**
         * @param args
         */
        public static void main(String[] args) {

            try {
                fontFace = args[0];
            } catch (Exception e) {
            }
            try {
                fontSize = Integer.parseInt(args[1]);
            } catch (Exception e) {
            }

            fontColorR = parse(args, 2, fontColorR);
            fontColorB = parse(args, 3, fontColorB);
            fontColorG = parse(args, 4, fontColorG);

            backgroundColorR = parse(args, 5, backgroundColorR);
            backgroundColorB = parse(args, 6, backgroundColorB);
            backgroundColorG = parse(args, 7, backgroundColorG);

            JFrame frame = new JFrame("Prosty edytor");

            Zadanie06_1 edit = new Zadanie06_1();

            edit.setFont(new Font(fontFace, 0, fontSize));
            edit.setForeground(new Color(fontColorR, fontColorB, fontColorG));
            edit.setBackground(new Color(backgroundColorR, backgroundColorB,
                    backgroundColorG));

            frame.getContentPane().add(edit);
            frame.setLocation(300, 300);
            frame.setPreferredSize(new Dimension(300, 300));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
    }
}
