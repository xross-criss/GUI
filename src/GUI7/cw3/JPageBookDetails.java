package GUI7.cw3;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JPageBookDetails extends JPanel {
    private JLabel l1, l2, l3, l4;
    private Image img1;
    private int maxlimit=20;

    public JPageBookDetails(Book book) {

        setLayout(null);

        img1 = loadImageAsImage(book.getPictureURL());

        l1 = new JLabel(book.getTitle());
        l1.setBounds(60, 10, 300, 20);
        l1.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(l1);

        l2 = new JLabel("napisana przez: " + book.getAuthor());
        l2.setBounds(60, 30, 200, 30);
        l2.setFont(new Font("Tahoma", Font.ITALIC | Font.BOLD, 12));
        add(l2);

        l3 = new JLabel(Book.formatDescription(book.getBookDescription(), maxlimit));
        l3.setBounds(210, 70, 180, 30);
        l3.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(l3);

        l4 = new JLabel("Cena: " + book.getPrice());
        l4.setBounds(210, 70, 180, 30);
        l4.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(l4);


    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(img1, 100, 100, this);
    }

    public static Image loadImageAsImage(String path) {
        Image ret = null;
        try {
            //System.out.println("/resources/img/" + path);
            ret = Toolkit.getDefaultToolkit().createImage(JPageBookDetails.class.getClass().getResource("/img/" + path));
        } catch (Exception e) {
            // TODO Exception
        }
        return ret;
    }
}