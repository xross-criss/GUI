package GUI7.cw3;

import javax.swing.*;
import java.awt.*;

public class BookDialog extends JDialog {

    private JButton save;
    private Book book;

    public BookDialog(Book book, JFrame parent) {
        super(parent);
        this.setSize(new Dimension(400, 300));
        this.setModal(true);
        this.setLayout(null);
        this.setLocationRelativeTo(parent);
//
//        l1 = new JLabel(book.getTitle());
//        l1.setBounds(60, 10, 300, 20);
//        l1.setFont(new Font("Tahoma", Font.BOLD, 18));
//        add(l1);

        this.book = book;

        this.save = new JButton("Save");
        this.save.setBounds(40, 40, 100, 20);
        this.save.addActionListener(e -> {
            setVisible(false);
            dispose();
        });
        this.add(this.save);
    }

    public Book showDialog() {
        setVisible(true);
        return book;
    }

}
