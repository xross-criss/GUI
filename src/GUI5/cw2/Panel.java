package GUI5.cw2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Panel extends JFrame {
    ImageIcon icon;
    JLabel label;
    Text text = new Text();

    public Panel(ArrayList<String> path, String waiter, String size) {
        int wait = Integer.parseInt(waiter) * 1000;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new FlowLayout());
        setResizable(false);
        craftImage(path, wait);

        text.setText("Koniec prezentacji");
        end(Integer.parseInt(size));
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
        label = new JLabel(text.getText(), JLabel.CENTER);
        Rectangle r = getBounds();
        int h = r.height;
        int w = r.width;
        label.setBounds(w / 2 - 200, h / 2 - 150, 300, 200);
        label.setFont(new Font(null, Font.BOLD, size));
        add(label);
    }
}