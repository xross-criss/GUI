package GUI6.cw2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerFontSize implements ActionListener {

    protected JTextArea handler;
    protected int fontSize;

    public ListenerFontSize(JTextArea handler, int size) {
        this.handler = handler;
        this.fontSize = size;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        handler.setFont(new Font("Times New Roman", Font.PLAIN, fontSize));
    }
}
