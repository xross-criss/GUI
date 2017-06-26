package GUI6.cw2;

import java.awt.*;

public class Icon implements javax.swing.Icon {

    protected Color color;
    protected int widht, height;

    public Icon() {
        this(10, 10, Color.GREEN);
    }

    public Icon(Color color) {
        this(10, 10, color);
    }

    public Icon(int width, int height) {
        this(width, height, Color.GREEN);
    }

    public Icon(int width, int height, Color color) {
        this.widht = width;
        this.height = height;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public int getIconHeight() {
        return height;
    }

    @Override
    public int getIconWidth() {
        return widht;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setColor(color);
        g.fillOval(x, y, widht, height);
    }
}
