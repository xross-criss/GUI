package GUI7.cw3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;

public class BookDialog extends JDialog {

    private JLabel l1, l2, l3, l4;
    private JButton getURL;
    private JButton save;
    private Book book;
    private static String titleString = "Title: ";
    private static String authorString = "Author/-s: ";
    private static String priceDoble = "Price: ";
    private static String descriptionString = "Description: ";

    private JTextField titleField;
    private JTextField authorField;
    private JTextField priceField;
    private JTextArea descriptionField;

    public BookDialog(Book book, JFrame parent) {
        super(parent);
        this.setSize(new Dimension(400, 300));
        this.setModal(true);
        this.setLayout(null);
        this.setLocationRelativeTo(parent);
        this.book = book;

        l1 = new JLabel(titleString);
        l2 = new JLabel(authorString);
        l3 = new JLabel(priceDoble);
        l4 = new JLabel(descriptionString);

        l1.setBounds(20, 30, 100, 20);
        l1.setFont(new Font("Tahoma", Font.BOLD, 12));
        titleField = new JTextField();
        titleField.setBounds(120, 30, 250, 20);
        titleField.setText(book.getTitle());
        titleField.setColumns(64);
        titleField.setEditable(true);
        this.add(l1);
        this.add(titleField);

        l2.setBounds(20, 60, 100, 20);
        l2.setFont(new Font("Tahoma", Font.BOLD, 12));
        authorField = new JTextField();
        authorField.setBounds(120, 60, 250, 20);
        authorField.setText(book.getAuthor() == null ? "" : book.getAuthor());
        authorField.setColumns(64);
        authorField.setEditable(true);
        this.add(l2);
        this.add(authorField);

        l3.setBounds(20, 90, 100, 20);
        l3.setFont(new Font("Tahoma", Font.BOLD, 12));
        priceField = new JTextField();
        priceField.setBounds(120, 90, 250, 20);
        priceField.setText(book.getPrice() == 0.0 ? "0.0": String.valueOf(book.getPrice()));
        priceField.setColumns(64);
        priceField.setEditable(true);
        this.add(l3);
        this.add(priceField);

        l4.setBounds(20, 120, 100, 20);
        l4.setFont(new Font("Tahoma", Font.BOLD, 12));
        descriptionField = new JTextArea(book.getBookDescription());
        descriptionField.setBounds(120,120,250,90);
        descriptionField.setColumns(255);
        this.add(l4);
        this.add(descriptionField);

        getURL = new JButton("set Cover Image");
        getURL.setBounds(20, 230, 160,20);
        getURL.addActionListener((ActionEvent e) ->{
            book.setPictureURL(MyFrame.openOpenPictureDialog());
        });
        this.add(getURL);

        this.save = new JButton("Save");
        this.save.setBounds(270, 230, 100, 20);
        this.save.addActionListener(e -> {
            book.setTitle(titleField.getText());
            book.setAuthor(authorField.getText());
            book.setPrice(Double.parseDouble(priceField.getText()));
            book.setBookDescription(descriptionField.getText());
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
