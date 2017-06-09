package GUI6.cw2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerBackground implements ActionListener {

    protected JTextArea handler;

    public ListenerBackground(JTextArea handler) {
        this.handler = handler;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem item = (JMenuItem) e.getSource();
        Icon icon = (Icon) item.getIcon();
        handler.setBackground(icon.getColor());
    }
}
