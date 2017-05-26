package GUI6.cw1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Zadanie 1 (max 2 punkty)
 * <p>
 * Przycisk umieszczony w oknie zmienia kolory swojego tła na skutek kliknięć
 * Ustalić dowolną sekwencję kolorów, po jej wyczerpaniu zacząć od pierwszego
 *
 */
public class Main extends JFrame {

    JButton button;
    int colorKey = 0;
    protected Color[] colors = new Color[]{Color.RED, Color.BLACK,
            Color.BLUE, Color.YELLOW, Color.WHITE, Color.GREEN};

    /**
     *
     */
    Main() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(200, 100));
        setLocation(200, 200);

        button = new JButton("Klik!");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (colorKey >= colors.length) {
                    colorKey = 0;
                }

                button.setBackground(colors[colorKey]);
                colorKey++;
            }
        });
        add(button);

        pack();
        setVisible(true);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }
}