package GUI5.cw2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Panel extends JFrame {
    ImageIcon icon;
    JLabel label;

    public Panel(ArrayList<String> path, int wait, int size) {
        wait *= 1000;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new FlowLayout());
        setResizable(false);
        craftImage(path, wait);
        end(size);
    }

    public void craftImage(ArrayList<String> path, int wait) {
        for (int i = 0; i < path.size(); i++) {
            icon = new ImageIcon(path.get(i));
            label = new JLabel(icon);
            add(label);
            pack();
            setLocationRelativeTo(null);
            try {
                Thread.sleep(wait);
            } catch (InterruptedException e) {
            }
            remove(label);
            revalidate();
            repaint();
        }
    }

    public void end(int size) {
        label = new JLabel("Zakończenie Prezentacji ", JLabel.CENTER);
        Rectangle r = getBounds();
        int h = r.height;
        int w = r.width;
        label.setBounds(w / 2 - 200, h / 2 - 150, 300, 200);
        label.setFont(new Font(null, Font.BOLD, size));
        add(label);
    }
}