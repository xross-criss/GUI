package GUI5.cw3;

import javax.swing.*;
import java.awt.*;

import static GUI5.cw3.Parser.parse;

public class Main extends JTextArea {

    private static String fontFace = "Dialog";
    private static int fontSize = 14;
    private static float fontColorR = 1, fontColorB = 1, fontColorG = 1;
    private static float backgroundColorR = 0, backgroundColorB = 0,
            backgroundColorG = 1;


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

        Main edit = new Main();

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
