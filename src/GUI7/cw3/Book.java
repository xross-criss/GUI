package GUI7.cw3;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Book {

    private String author;
    private String title;
    private double price;
    private String bookDescription;
    private String pictureURL;

    public Book(String author, String title, double price, String bookDescription, String pictureURL) {
        this.author = author;
        this.title = title;
        this.price = price;
        this.bookDescription = bookDescription;
        this.pictureURL = pictureURL;
    }

    public Book() {
        this("", "", 0.0, "", "");
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public ImageIcon getImageIcon() {
        try {
            final BufferedImage image = ImageIO.read(new File(getPictureURL()));
            return new ImageIcon(resize(image, (int) Math.round(1.0 * image.getWidth() / (image.getWidth() / 64)), 64));
        } catch (Exception e) {
            return null;
        }
    }

    private BufferedImage resize(BufferedImage originalImage, int width, int height) {
        BufferedImage resizedImage = new BufferedImage(width, height, originalImage.getType());
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose();
        g.setComposite(AlphaComposite.Src);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        return resizedImage;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", bookDescription='" + bookDescription + '\'' +
                ", pictureURL='" + pictureURL + '\'' +
                '}';
    }

}
