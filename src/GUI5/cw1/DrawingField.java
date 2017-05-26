package GUI5.cw1;

import javax.swing.*;
import java.awt.*;

public class DrawingField extends JComponent {

    public DrawingField(int w, int h) {
        Dimension d = new Dimension(w, h);
        setMinimumSize(d);
        setPreferredSize(new Dimension(d));
        setMaximumSize(d);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();
        g.setColor(Color.blue);

        g.drawLine(0, 0 , w-1, h-1);
        g.drawLine(w-1, 0 , 0, h-1);

    }
}