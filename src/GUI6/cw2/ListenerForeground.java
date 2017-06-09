package GUI6.cw2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerForeground implements ActionListener {

    protected JTextArea handler;

    /**
     *
     * @param handler
     */
    public ListenerForeground(JTextArea handler) {
        this.handler = handler;
    }

    /**
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem item = (JMenuItem) e.getSource();
        MyIcon icon = (MyIcon) item.getIcon();
        handler.setForeground(icon.getColor());
    }
}
